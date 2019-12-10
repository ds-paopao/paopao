<template>
    <div >

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
        },
        watch:{
           /* isLogin:function () {
                this.$emit("changLogin",this.isLogin)
            },
            loginForm:function () {

                  this.$emit("changLoginForm",this.loginForm)

            }*/
        }
    }
</script>

<style scoped>

</style>