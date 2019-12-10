<template>
    <div>

        <el-menu
                style="width: 100%"
                :default-active="$router.path"
                class="el-menu-demo"
                mode="horizontal"
                @select="handleSelect"
                background-color="#1E89E0"
                text-color="#fff"
                active-text-color="#ffd04b"
                :router="true">

            <el-menu-item index="3">悬赏列表</el-menu-item>
            <el-menu-item index="/home/list/orderList">订单列表</el-menu-item>
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
    .el-menu {
        /*margin-left: 0%;*/
        float: none;
        /*margin-left: -1%;*/
        width: 600px;
    }
</style>