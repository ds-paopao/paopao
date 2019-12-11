<template>
    <div>
        <el-card class="box-card">
            <div style="margin-top: 15px;">

                    <el-tabs v-model="activeName" @tab-click="handleClick">
                        <el-tab-pane  label="已接悬赏" name="first">
                            <el-card shadow="hover" style="margin-top: 10px" v-for="i in 5">
                                <el-row>
                                    <el-col :span="6">
                                        <el-image :src="'@/assets/logo.png'"></el-image>
                                    </el-col>
                                    <el-col :span="18">
                                        <el-row>
                                            <h3>标题</h3>
                                        </el-row>
                                        <el-row>
                                            <p>
                                                zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzasdas
                                                dddddddddddddddddddddddddddddddddddddddddddddddddddddd
                                                asddddddddddddddddddddddddddddddddddddddddddd
                                                asddddddddddddddddddddddddddddddddddddddddddd
                                            </p>
                                        </el-row>
                                    </el-col>
                                </el-row>
                            </el-card>

                        </el-tab-pane>
                        <el-tab-pane label="我发布的悬赏" name="second">
                            <el-card shadow="hover" style="margin-top: 10px" v-for="i in 5">
                                <el-row>
                                    <el-col :span="6">
                                        <el-image :src="'@/assets/logo.png'"></el-image>
                                    </el-col>
                                    <el-col :span="18">
                                        <el-row>
                                            <h3>标题</h3>
                                        </el-row>
                                        <el-row>
                                            <p>
                                                zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzasdas
                                                dddddddddddddddddddddddddddddddddddddddddddddddddddddd
                                                asddddddddddddddddddddddddddddddddddddddddddd
                                                asddddddddddddddddddddddddddddddddddddddddddd
                                            </p>
                                        </el-row>
                                    </el-col>
                                </el-row>
                            </el-card>

                        </el-tab-pane>
                    </el-tabs>

            </div>
        </el-card>
    </div>
</template>

<script>
    export default {
        name: "index",
        methods: {
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
                console.log(`当前页: ${val}`);
            }
        },data() {
            return {
                key: '',
                activeName:'first'
            }
        }

    }
</script>

<style scoped>
    .xs-item {
        float: left;
        margin-top: 10px;
    }

    .item-card {
        height: 150px;
        margin-top: 10px;

    }

    .box-card {

        width: 60%;
        height: 100%;
        margin: 0 auto;
    }

    .el-tabs {
        margin-top: 20px;
    }


    .time {
        font-size: 13px;
        color: #999;
    }

    .bottom {
        margin-top: 13px;
        line-height: 12px;
    }

    .button {
        width: 100px;
        height: 50px;
        padding: 0;
        float: right;
        margin-bottom: 5px;
        margin-right: 2px;

    }

    .image {
        width: 150px;
        height: 100%;
        display: block;
    }

    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }

    .clearfix:after {
        clear: both
    }
</style>