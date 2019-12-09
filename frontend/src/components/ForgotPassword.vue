<template>
    <div >
        <el-dialog title="找回密码" :visible.sync="loginForm">
            <el-form >
                <el-form-item label="手机号" :label-width="formLabelWidth">
                    <el-input  autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item v-if="!isLogin" label="验证码" :label-width="formLabelWidth">
                    <el-input  autocomplete="off" style="width: 300px;float: left"></el-input>
                    <verifyCode></verifyCode>
                </el-form-item>
                <el-form-item label="新密码" :label-width="formLabelWidth">
                    <el-input  autocomplete="off"></el-input>
                </el-form-item>
                <div style="float: left">
                    <el-link type="primary" href="/login" >登录</el-link>
                </div>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="loginForm = false">取 消</el-button>
                <el-button type="primary" @click="loginForm = false">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    import verifyCode from '@/components/VerifyCode.vue'
    export default {
        name: "ForgotPassword",
        data(){
            return{
                loginForm: true,
                formLabelWidth:'120px'
            }
        },
        methods:{

        },
        components:{
            verifyCode
        }
    }
</script>

<style scoped>
    /*.el-input{*/
    /*    width: 200px;*/
    /*}*/
</style>