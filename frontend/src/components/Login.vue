<template>
    <div >
        <el-dialog :title="isLogin ? '登录' : '注册'" :visible.sync="loginForm">
            <el-form >
                <el-form-item label="手机号" :label-width="formLabelWidth">
                    <el-input  autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="密码" :label-width="formLabelWidth">
                    <el-input  autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item v-if="!isLogin" label="验证码" :label-width="formLabelWidth">
                    <el-input  autocomplete="off" style="width: 300px;float: left"></el-input>
                    <verifyCode></verifyCode>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <div style="float: left">
                    <el-link type="primary" href="/forgotPwd" style="margin-right: 20px">忘记密码?</el-link>
                    <el-link type="primary" @click="isLogin = !isLogin">{{isLogin ? '注册' : '登录'}}</el-link>
                </div>
                <el-button @click="loginForm = false">取 消</el-button>
                <el-button type="primary" @click="loginForm = false">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    import verifyCode from '@/components/VerifyCode.vue'
    export default {
        name: "Login",
         data(){
             return{
                 formLabelWidth:'120px'
             }
         },
        props:[
            'isLogin','loginForm'
        ],
        methods:{

        },
        components:{
            verifyCode
        }
    }
</script>

<style scoped>

</style>