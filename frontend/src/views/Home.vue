<template>
    <div class="home">
        <el-container>


            <el-container>
                <el-header>
                    <el-row>
                        <el-col :span="16">
                            <div style="width: 60%;margin: auto 0">
                                <menus></menus>
                            </div>
                        </el-col>
                        <el-col :span="5">
                            <el-dropdown v-if="isLogin">
                      <span class="el-dropdown-link">
                       <img src="@/assets/logo.png" width="30px" height="30px" style="border-radius:50%;"><i
                              class="el-icon-arrow-down el-icon--right"></i>
                      </span>
                                <el-dropdown-menu slot="dropdown">
                                    <el-dropdown-item>个人信息</el-dropdown-item>
                                    <el-dropdown-item>我的订单</el-dropdown-item>
                                    <el-dropdown-item>我的悬赏</el-dropdown-item>
                                    <el-dropdown-item divided>退出登录</el-dropdown-item>
                                </el-dropdown-menu>
                            </el-dropdown>
                            <div v-else>
                                <a @click.prevent="openLogin = true">登录</a>
                            </div>
                        </el-col>
                        <el-col :span="3">
                            <el-menu class="el-menu-vertical-demo" :collapse="isCollapse">
                                <el-row style="height: 100%">
                                    <el-col span="5" style="height: 100%;background: #504D53">

                                    </el-col>

                                    <el-col span="19" style="background: #1E89E0">

                                    </el-col>
                                </el-row>
                            </el-menu>
                        </el-col>
                    </el-row>


                </el-header>
                <el-main>
                    <router-view/>
                </el-main>
                <el-footer>Footer</el-footer>
            </el-container>
            <el-aside width="20px" style="z-index: 100">
                <div style="height: 40%"></div>
                <div class="car" @click="clickOpen">
                    <div>购</div>
                    <div>物</div>
                    <div>车</div>
                    <el-icon icon="el-icon-sold-out"></el-icon>
                </div>
            </el-aside>
        </el-container>
        <scroll-top></scroll-top>
        <Login :isLogin="isLogin" :loginForm="openLogin"></Login>
    </div>
</template>

<script>
    // @ is an alias to /src
    import menu from '@/components/menu'
    import ScrollTop from '@/components/scroll'
    import Login from '@/components/Login'

    export default {
        name: 'home',
        data() {
            return {
                openLogin: false,
                isLogin: false,
                isCollapse: true
            }
        },
        methods: {
            clickOpen() {
                this.isCollapse = !this.isCollapse;
            }
        },
        components: {
            Login,
            menus: menu,
            'scroll-top': ScrollTop,
        }
    }
</script>
<style>
    .car {
        margin: auto 0;
        color: #ffffff;
    }

    .el-aside {
        background-color: #504D53;
        color: #333;
        text-align: center;
    }

    .el-dropdown {

    }

    html, body, #app, .el-container {
        /*设置内部填充为0，几个布局元素之间没有间距*/
        padding: 0px;
        /*外部间距也是如此设置*/
        margin: 0px;
        /*统一设置高度为100%*/
        height: 100%;
    }

    .el-menu-vertical-demo:not(.el-menu--collapse) {
        width: 300px;
        min-height: 1200px;

    }

    .el-header {
        background-color: #1E89E0;
        color: #333;
        text-align: center;
        width: 100%;
        line-height: 60px;
    }


    .el-menu {
        margin-left: -1%;
        width: 400px;

    }

    .el-main {
        background-color: #F7F7F7;
        color: #333;
        text-align: center;

    }

    .el-container {
        height: 100%;
        padding: 0;
        margin: 0;
        width: 100%;
    }


    .box-card {

        width: 60%;
        height: 100%;
        margin: 0 auto;
    }


</style>