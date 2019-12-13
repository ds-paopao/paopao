<template>
    <div class="home">
        <el-container>
            <el-container>
                <el-header>
                    <el-row>
                        <!-- logo start -->
                        <el-col :span="4" class="logo">
                            <img src="@/assets/logo.png" width="150px" height="50px">
                        </el-col>
                        <!-- logo end -->
                        <!-- 导航栏 start -->
                        <el-col :span="12">
                            <div style="width: 60%;margin: auto 0">
                                <menus></menus>
                            </div>
                        </el-col>
                        <!-- 导航栏 end -->
                        <!-- 登录头像 start -->
                        <el-col :span="5" class="login">
                            <el-dropdown v-if="isLogin">
                      <span class="el-dropdown-link">
                           <el-avatar icon="el-icon-user-solid" style="margin-top: 10px"></el-avatar>
                      </span>
                                <el-dropdown-menu slot="dropdown">
                                    <el-dropdown-item>个人信息</el-dropdown-item>
                                    <el-dropdown-item >历史订单</el-dropdown-item>
                                    <!--点击路由转发-->
                                    <el-dropdown-item ><span @click.stop="$router.push('/home/reward')">我的悬赏</span></el-dropdown-item>
                                    <el-dropdown-item divided>退出登录</el-dropdown-item>
                                </el-dropdown-menu>
                            </el-dropdown>
                            <div v-else>
                                <a @click.prevent="openLogin = true" href="#">登录/注册</a>
                            </div>
                        </el-col>
                        <!-- 登录头像 end -->
                    </el-row>

                </el-header>


                <el-main>
                    <router-view/>
                </el-main>

                <el-footer>
                    Footer
                </el-footer>
            </el-container>
            <!-- <el-aside width="50px" style="z-index: 100">
                 <div style="height: 40%"></div>
                 <div class="car" @click="clickOpen">
                     <div>购</div>
                     <div>物</div>
                     <div>车</div>
                     <el-icon icon="el-icon-sold-out"></el-icon>
                 </div>
             </el-aside>-->
        </el-container>

        <!-- 回到顶部组件 start -->
        <el-backtop :bottom="100">

        </el-backtop>
        <!-- 回到顶部组件 end -->

        <!-- 登录组件 start -->
        <el-dialog :title="isLogin ? '登录' : '注册'" :visible.sync="openLogin">
            <el-form>
                <el-form-item label="手机号" :label-width="100">
                    <el-input v-model="user.phone" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="密码" :label-width="100">
                    <el-input v-model="user.password" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item v-if="!isLogin" label="验证码" :label-width="100">
                    <el-input autocomplete="off" v-model="user.code" style="width: 300px;float: left"></el-input>
                    <verifyCode></verifyCode>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <div style="float: left">
                    <el-link type="primary" href="/forgotPwd" style="margin-right: 20px">忘记密码?</el-link>
                    <el-link type="primary" @click="isLogin = !isLogin">{{isLogin ? '注册' : '登录'}}</el-link>
                </div>
                <el-button @click="openLogin = false">取 消</el-button>
                <el-button type="primary" @click="login()">确 定</el-button>
            </div>
        </el-dialog>
        <!-- 登录组件 end -->
    </div>
</template>

<script>
    // @ is an alias to /src
    import menu from '@/components/menu'
    import ScrollTop from '@/components/scroll'
    import Login from '@/components/Login'
    import verifyCode from '@/components/VerifyCode.vue'

    export default {
        name: 'home',
        data() {
            return {
                openLogin: false,
                isLogin: false,
                isCollapse: true,
                user: {}
            }
        },
        methods: {
            async login() {
                let {data} = await this.$axios.get("/user/login", this.user);
                if (data.code == 1) {
                    this.$message({
                        showClose: true,
                        message: '登录成功',
                        type: 'success'
                    });
                    this.isLogin = true;
                    this.openLogin = false;
                } else {
                    this.$message({
                        showClose: true,
                        message: '账号或密码错误',
                        type: 'error'
                    });
                }
            },
            clickOpen() {
                this.isCollapse = !this.isCollapse;
            },
            changLoginForm(val) {
                this.openLogin = val;
            },
            changLogin(val) {
                this.isLogin = val;
            }
        },
        components: {
            Login,
            menus: menu,
            'scroll-top': ScrollTop,
            verifyCode
        }
    }
</script>
<style>
    a {
        text-decoration: none;
        color: white;
    }

    .car {
        margin: auto 0;
        color: #ffffff;
    }

    .el-aside {
        background-color: #504D53;
        color: #333;
        text-align: center;
    }

    .page-component__scroll {
        height: 100%;
    }

    .el-scrollbar__wrap {
        overflow-x: hidden;
    }

    .page-component__scroll .el-scrollbar__wrap {
        overflow-x: auto;
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

    .logo {
        margin-left: 20%;
    }

    .login {
        margin-left: -20%;
    }
</style>