<template>
    <el-dialog
            title="我要一瓶王老吉"
            :visible.sync="thisOpen"
            width="50%"
    >
        <el-row style="margin-bottom: 20px">
            <el-col>
                <font >
                    拜托老兄去大润发给我带一瓶王老吉
                </font>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="13"><font color="#a9a9a9">交货地址 : 229宿舍</font></el-col>
        </el-row>
        <el-row>
            <el-col :span="13"><font color="#a9a9a9">截止时间：2019-9-9</font></el-col>
            <el-col :span="11">悬赏金额 : <font color="red" size="10px">5</font></el-col>
        </el-row>
        <span slot="footer" class="dialog-footer">
    <el-button @click="thisOpen = false">取 消</el-button>
    <el-button type="primary" @click="thisOpen = false">接受悬赏</el-button>
  </span>
    </el-dialog>
</template>

<script>
    export default {
        name: "daiog",
        data(){
            return{
                thisOpen:false
            }
        },
        props:[
            'open'
        ],
        methods:{

        },
       updated() {

       },

        watch:{
            thisOpen(){

                this.$emit("changes",this.thisOpen)
            },
            open(){

                this.thisOpen = this.open;
            }
        }
    }
</script>

<style scoped>

</style>