<template>
    <div>
        <el-card class="box-card">
            <div style="margin-top: 15px;">
                <!--sta搜索框-->
                <el-input placeholder="搜索我的订单" v-model="key" class="input-with-select">
                    <el-button slot="append" type="primary" style="color: white;background-color: #1E89E0"
                               icon="el-icon-search">搜索
                    </el-button>
                </el-input>
                <!--end搜索框-->
                <!--sta订单列表-->
                <el-tabs type="border-card">
                    <el-tab-pane label="默认">
                        <el-card :body-style="{ padding: '0px' }" class="item-card" v-for=" i in 5">
                            <el-row>
                                <el-col :span="6"><img src="../../assets/logo.png" class="image"/></el-col>
                                <el-col :span="15">
                                    <el-row>
                                        <span><h3 class="xs-item">订单简述</h3></span>
                                        <span><h5 class="xs-item">悬赏价格</h5></span>
                                    </el-row>
                                    <el-row>
                                        <div class="xs-item">接单人</div>
                                    </el-row>
                                    <el-row>
                                        <div class="xs-item">状态:</div>
                                    </el-row>
                                    <el-row>
                                        <div class="xs-item">悬赏地址</div>
                                    </el-row>
                                </el-col>
                                <el-col :span="3">
                                    <el-row style="height: 100px">
                                    </el-row>
                                    <el-button type="primary" icon="el-icon-goods" class="button">订单详情</el-button>
                                </el-col>
                            </el-row>
                        </el-card>
                        <!--end订单列表-->
                        <!--sta分页组件-->
                        <el-pagination
                                style="margin-top: 10px"
                                @size-change="handleSizeChange"
                                @current-change="handleCurrentChange"
                                :current-page="1"
                                :page-sizes="[100, 200, 300, 400]"
                                :page-size="100"
                                layout="total, sizes, prev, pager, next, jumper"
                                :total="400">
                        </el-pagination>
                        <!--end分页组件-->
                    </el-tab-pane>
                    <el-tab-pane label="未完成订单">已完成订单</el-tab-pane>
                    <el-tab-pane label="已完成的订单">已完成的订单</el-tab-pane>
                    <el-tab-pane label="失效订单">失效订单</el-tab-pane>
                </el-tabs>
            </div>


        </el-card>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                key: ''
            }
        },
        methods: {
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
                console.log(`当前页: ${val}`);
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