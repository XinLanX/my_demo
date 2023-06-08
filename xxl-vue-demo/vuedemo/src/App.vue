<template>
  <div id="app">
<!--    <img alt="Vue logo" src="./assets/logo.png">-->
<!--    <HelloWorld msg="Welcome to Your Vue.js App"/>-->
<!--    <SysUser></SysUser>-->

<!--    <router-link :to="/foo">跳转跳转</router-link>-->
<!--    <HelloWorld/>-->
      <el-input v-model="sqlForm.url" placeholder="请输入url"></el-input>
      <el-input v-model="sqlForm.userName" placeholder="请输入userName"></el-input>
      <el-input v-model="sqlForm.pwd" placeholder="请输入pwd"></el-input>
      <el-input v-model="sqlForm.sql" placeholder="请输入sql"></el-input>
    <el-button @click="getList()">执行</el-button>

    <el-dialog
            :title="'查询结果'"
            :visible.sync="tableVisible"
            :append-to-body="true"
            width="60%"
            @close="sqlForm.pageNum=1,sqlForm.pageSize=10,sqlMapList=[]"
            :fullscreen="false">
      <el-table :data="sqlMapList"  style="width: 100%  ">
        <el-table-column type="index" width="50%" label="序号"></el-table-column>
        <template v-for='(col) in sqlMapTable'>
          <el-table-column
                  :show-overflow-tooltip="true"
                  :prop="col.dataItem"
                  :label="col.dataName"
                  :key="col.dataItem"
                  width="124px">
          </el-table-column>
        </template>
      </el-table>
      <div class="page_box" >
        <el-pagination
                :total="sqlTotal"
                :current-page="sqlForm.pageNum"
                :page-size="sqlForm.pageSize"
                @size-change="sqlHandleSizeChange"
                @current-change="sqlHandleCurrentChange"
                :page-sizes="[10,20,30,40]"
                background
                layout="total, prev, pager, next, sizes, jumper"></el-pagination>
      </div>
    </el-dialog>

  </div>

</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'
// import SysUser from "./main/sysUser";
import {executeSqlTable, executeSql}from "./api/base/sysUser.js";
export default {
  name: 'App',
  components: {
    // SysUser,
    // HelloWorld
  },
  data() {
    return {
        tableVisible: false,
      sqlTotal:0,
      sqlMapList: [],
      sqlMapTable: [],
        sqlForm:{
          url:"",
          userName:"",
          pwd:"",
            sql:"",
            pageSize:10,
            pageNum:1

        },


      tableData: [{
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '2016-05-04',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1517 弄'
      }, {
        date: '2016-05-01',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1519 弄'
      }, {
        date: '2016-05-03',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1516 弄'
      }]
    }
  },
  methods: {

    sqlHandleSearch() {
      this.sqlForm.pageNum = 1
      this.sqlForm.pageSize = 10
      this.sqlExecute()
    },
    sqlHandleSizeChange(val) {
      this.sqlForm.pageNum = 1
      this.sqlForm.pageSize = val
      this.sqlExecute()
    },

    sqlHandleCurrentChange(val) {
      this.sqlForm.pageNum = val
      this.sqlExecute()
    },
    async sqlExecute(){
      await executeSql(this.sqlForm).then(res => {
        console.log(res.data)
        this.executeFlag = true
        this.sqlMapList = res.data.items
        this.sqlTotal = res.count
      }).catch(() => {false
        this.executeFlag = false
        // this.$message.error('执行失败')
      })
      if (!this.executeFlag){
        return
      }
      await executeSqlTable(this.sqlForm).then(res=>{
        this.sqlMapTable = res
      }).catch(()=>{
        this.$message.error('获取表头失败')
      })
    },
    getList(){
      this.sqlExecute()
      this.tableVisible=true
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

.table_container{
  padding: 16px;
.table_box{
  border: 1px solid #EBEEF5;
  padding: 0px;
}
.page_box{
  margin-top: 20px;
  display: flex;
  flex-direction: row-reverse;
}
}
.el-dialog__body{
  padding-top: 0;
  padding-bottom: 0;
}
::v-deep .el-dialog__header {
  padding: 20px 20px 20px 40px;
}
::v-deep .el-dialog__title{
  font-size: 23px;
  font-weight: 700;
}
::v-deep .el-dialog__footer{
  text-align: center;
}
::v-deep .el-dialog__body{
  padding-top: 0;
  padding-bottom: 0;
}
</style>
