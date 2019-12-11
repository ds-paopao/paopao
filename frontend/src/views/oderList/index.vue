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
                <div style="height: 1039px">
                    <el-table
                            :stripe="true"
                            :data="orders"
                            style="width: 100%">
                        <el-table-column  type="expand" >
                            <template slot-scope="order">
                                <el-form  label-position="left" inline class="demo-table-expand">
                                    <el-form-item label="订单详情">
                                        <span>{{ order.row.xs.context}}</span>
                                    </el-form-item>
                                    <el-form-item label="预计价格">
                                        <span>{{ order.row.xs.price }}</span>
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
                </div>
                <!--end订单列表-->

            </div>


        </el-card>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                orders: [{
                    oid: '订单的id',
                    xsId: '悬赏表的id',
                    lansquenet: '接单人的id',
                    state: 1,
                    showOne: 1,
                    showTwo: 1,
                    createTime: '2011-11-11 11:11:11',
                    endTime: '2012-12-12 12:12:12',
                    xs: {
                        xsId: '悬赏表的id',
                        brief: '帮买东西',
                        context: '在大润发买五瓶矿泉水,好多好吃的',
                        price: 11.11,
                        createTime: '2011-11-11 11:11:11',
                        endTime: '2012-12-12 12:12:12',
                        state: 1,
                        uid: '发布悬赏人的id',
                        address: '520宿舍2号床',
                        user:{
                            nickname:'吴彦祖',
                            phone:'13313131414'
                        }
                    }
                },{
                    oid: '订单的id',
                    xsId: '悬赏表的id',
                    lansquenet: '接单人的id',
                    state: 1,
                    showOne: 1,
                    showTwo: 1,
                    createTime: '2011-11-11 11:11:11',
                    endTime: '2012-12-12 12:12:12',
                    xs: {
                        xsId: '悬赏表的id',
                        brief: '帮买东西',
                        context: '在大润发买五瓶矿泉水,好多好吃的',
                        price: 11.11,
                        createTime: '2011-11-11 11:11:11',
                        endTime: '2012-12-12 12:12:12',
                        state: 1,
                        uid: '发布悬赏人的id',
                        address: '520宿舍2号床',
                        user:{
                            nickname:'吴彦祖',
                            phone:'13313131414'
                        }
                    }
                },{
                    oid: '订单的id',
                    xsId: '悬赏表的id',
                    lansquenet: '接单人的id',
                    state: 1,
                    showOne: 1,
                    showTwo: 1,
                    createTime: '2011-11-11 11:11:11',
                    endTime: '2012-12-12 12:12:12',
                    xs: {
                        xsId: '悬赏表的id',
                        brief: '帮买东西',
                        context: '在大润发买五瓶矿泉水,好多好吃的',
                        price: 11.11,
                        createTime: '2011-11-11 11:11:11',
                        endTime: '2012-12-12 12:12:12',
                        state: 1,
                        uid: '发布悬赏人的id',
                        address: '520宿舍2号床',
                        user:{
                            nickname:'吴彦祖',
                            phone:'13313131414'
                        }
                    }
                },{
                    oid: '订单的id',
                    xsId: '悬赏表的id',
                    lansquenet: '接单人的id',
                    state: 1,
                    showOne: 1,
                    showTwo: 1,
                    createTime: '2011-11-11 11:11:11',
                    endTime: '2012-12-12 12:12:12',
                    xs: {
                        xsId: '悬赏表的id',
                        brief: '帮买东西',
                        context: '在大润发买五瓶矿泉水,好多好吃的',
                        price: 11.11,
                        createTime: '2011-11-11 11:11:11',
                        endTime: '2012-12-12 12:12:12',
                        state: 1,
                        uid: '发布悬赏人的id',
                        address: '520宿舍2号床',
                        user:{
                            nickname:'吴彦祖',
                            phone:'13313131414'
                        }
                    }
                }]
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