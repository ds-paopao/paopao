<template>
    <div>
        <el-card class="box-card">
            <div style="margin-top: 15px;">
                <el-input placeholder="请输入要搜索的悬赏名 或者店铺" v-model="key" class="input-with-select">

                    <el-button slot="append"  type="primary" icon="el-icon-search">搜索</el-button>
                </el-input>

                <el-tabs type="border-card">
                    <el-tab-pane label="默认排序">
                        <el-card :body-style="{ padding: '0px' }" class="item-card" v-for=" i in 5">

                            <!--                            <img src="~examples/assets/images/hamburger.png" class="image">-->


                            <el-row>
                                <el-col :span="4"><img src="../../assets/logo.png" class="image"/></el-col>
                                <el-col :span="17">
                                    <el-row><h3 class="xs-item">标题</h3></el-row>
                                    <el-row>
                                        <div class="xs-item">悬赏地址</div>
                                    </el-row>
                                    <el-row>
                                        <div class="xs-item">悬赏地址</div>
                                    </el-row>
                                    <el-row>
                                        <div class="xs-item">悬赏地址</div>



                                    </el-row>


                                </el-col>

                                <el-col :span="3">

                                   <el-row style="height: 100px">

                                   </el-row>
                                        <el-button type="primary" icon="el-icon-goods"  class="button">查看悬赏</el-button>

                                </el-col>
                            </el-row>


                        </el-card>

                        <el-pagination
                                style="margin-top: 10px"
                                @size-change="1"
                                @current-change="handleCurrentChange"
                                :current-page="1"
                                :page-sizes="[100, 200, 300, 400]"
                                :page-size="100"
                                layout="total, sizes, prev, pager, next, jumper"
                                :total="400">
                        </el-pagination>
                    </el-tab-pane>
                    <el-tab-pane label="价格排序">价格排序</el-tab-pane>
                    <el-tab-pane label="距离排序">距离排序</el-tab-pane>
                    <el-tab-pane label="时间排序">时间排序</el-tab-pane>
                </el-tabs>
            </div>


        </el-card>
    </div>
</template>

<script>
    export default {
        name: "index"
        , data() {
            return {
                key: ''
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