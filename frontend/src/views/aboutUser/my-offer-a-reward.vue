<template>
    <div>
        <!-- todo 登录后,此页面查询悬赏数据,包括(可接状态,状态码1 or 已接状态,状态码2)-->

        <el-card class="box-card">
            <div style="margin-top: 15px;">
                <el-switch
                        style=" margin-right: 44px;"
                        v-model="inSwitch"
                        active-color="#13ce66"
                        inactive-color="#ff4949"
                        active-text="已被接单"
                        inactive-text="等待接单">
                </el-switch>
                <!--sta搜索框-->
                <el-input style="width: 500px" placeholder="输入订单关键字" v-model="pageRequest.searchKey"
                          class="input-with-select">
                </el-input>
                <el-button slot="append" type="primary" style="color: white;background-color: #1E89E0"
                           icon="el-icon-search">搜索
                </el-button>
                <!--end搜索框-->
                <!--sta订单列表-->
                <div style="height: 900px">
                    <el-table
                            :show-overflow-tooltip="true"
                            :stripe="true"
                            :data="orders"
                            style="width: 100%"
                            :highlight-current-row="true"
                            :default-expand-all="true">
                        <el-table-column type="expand">
                            <template slot-scope="order">
                                <el-form label-position="left" inline class="demo-table-expand">
                                    <el-form-item label="订单详情">
                                        <span>{{ order.row.xs.context}}</span>
                                    </el-form-item>
                                    <el-form-item>
                                        <span v-if="order.row.state==1"><el-button size="mini" type="success" round>进行中...</el-button>
                                        </span>
                                    </el-form-item>
                                    <el-form-item label="预计价格">
                                        <span>{{ order.row.xs.price }}</span>
                                    </el-form-item>
                                    <el-form-item label="图片">
                                        <span>{{order.row.productphoto}}</span>
                                    </el-form-item>
                                    <el-form-item label="悬赏用户">
                                        <span>{{ order.row.xs.user.nickname }}</span>
                                    </el-form-item>
                                    <el-form-item label="悬赏用户电话">
                                        <span>{{ order.row.xs.user.phone }}</span>
                                    </el-form-item>
                                </el-form>
                            </template>
                        </el-table-column>
                        <div>
                            <el-table-column
                                    type="index"
                                    width="50">
                            </el-table-column>
                            <el-table-column
                                    width="80">
                                <i class="el-icon-s-custom"></i>
                            </el-table-column>
                            <el-table-column
                                    label="悬赏简述"
                                    prop="xs.brief">
                            </el-table-column>
                            <el-table-column
                                    label="交付地点"
                                    prop="xs.address">
                            </el-table-column>
                            <el-table-column
                                    label="限时"
                                    prop="xs.endTime">
                            </el-table-column>
                        </div>
                    </el-table>
                    <!--sta分页插件-->
                    <div>
                        <el-pagination
                                @current-change="handleCurrentChange"
                                background
                                layout="prev, pager, next, total"
                                :total="total">
                        </el-pagination>
                    </div>
                    <!--end分页插件-->
                </div>
                <!--end订单列表-->

            </div>


        </el-card>

        <div>
        </div>
    </div>
</template>

<script>
    import moke from '../../../mock/api.js'

    export default {
        data() {
            return {
                inSwitch: false,
                pageRequest: {
                    pageSize: 4,
                    pageNum: 1,
                    searchKey: ''
                },
                total: 0,
                orders: []
            }
        },
        methods: {
            handleCurrentChange(val) {
                this.pageRequest.pageNum = val;
                this.getAllOrder();
            },
            async getAllOrder() {
                let {data} = await this.$axios.get("http://localhost:8080/order/getAllOrder", {
                    param: this.pageRequest
                })
                console.log(data)
                this.orders = data.data.orders;
            }
        },
        created() {
            this.getAllOrder();
        }
    }
</script>


<style scoped>
    /*列表*/
    .demo-table-expand {
        font-size: 20px;
    }

    .demo-table-expand label {
        width: 90px;
        color: #99a9bf;
    }

    .demo-table-expand .el-form-item {
        margin-right: 0;
        margin-bottom: 0;
        color: #42b983;
        width: 50%;
    }

    /*列表*/
</style>