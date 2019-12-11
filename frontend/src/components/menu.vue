<template>
    <div >

         <el-menu
                 style="width: 100%"
                 :default-active="$route.path"
                 class="el-menu-demo"
                 mode="horizontal"
                 @select="handleSelect"
                 background-color="#1E89E0"
                 text-color="#fff"
                 :router="true"
                 active-text-color="#ffd04b">

             <el-menu-item index="/">悬赏列表</el-menu-item>
             <el-menu-item index="/home/oderList">进行中悬赏</el-menu-item>
             <el-menu-item index="/Addxs">发布悬赏</el-menu-item>
         </el-menu>
    </div>
</template>

<script>
    export default {
        name: "menu",
        data() {
            return {
                activeIndex: '1',
                activeIndex2: '1',

            };
        },
        methods: {
            handleSelect(key, keyPath) {
                console.log(key, keyPath);
            }
        }
    }
</script>

<style scoped>
    .el-menu{
        /*margin-left: 0%;*/
        float: none;
       /*margin-left: -1%;*/
        width: 600px;
    }
</style>