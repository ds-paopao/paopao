<template>
    <div>
        <el-button type="primary" @click="sendVerifyCode" v-text="verifyButtonText"></el-button>
    </div>
</template>

<script>
    export default {
        name: "VerifyCode",
        data(){
            return{
                reset:null,
                verifyButtonText:'发送验证码',
            }
        },
        methods:{
            sendVerifyCode(){
                if (this.reset)return;
                let countDown = 3;
                this.reset = setInterval(() => {
                    this.verifyButtonText = '重新发送('+--countDown+')';
                    if (countDown === 0){
                        this.verifyButtonText = '发送验证码';
                        clearInterval(this.reset);
                        this.reset = null
                    }
                },1000)
            }
        }
    }
</script>

<style scoped>

</style>