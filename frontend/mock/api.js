import Mock from 'mockjs'


    Mock.mock('http://localhost:8080/user/login', {
        'code': 1,
        'msg':'登录成功',
        'data':{}
    })

    Mock.mock("http://localhost:8080/order/getAllOrder",{
        'code': 1,
        'msg':'查询成功',
        'data':{
            orders: [{
                oid: '订单的id',
                xsId: '悬赏表的id',
                lansquenet: '接单人的id',
                state: 1,
                showOne: 1,
                showTwo: 1,
                createTime: '2011-11-11 11:11:11',
                endTime: '2012-12-12 12:12:12',
                productphoto:{
                    oid:'123',
                    photoUrl:"@/assets/logo.png"
                },
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
                    user: {
                        nickname: '吴彦祖',
                        phone: '13313131414'
                    }
                }
            }, {
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
                    user: {
                        nickname: '吴彦祖',
                        phone: '13313131414'
                    }
                }
            }, {
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
                    user: {
                        nickname: '吴彦祖',
                        phone: '13313131414'
                    }
                }
            }, {
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
                    user: {
                        nickname: '吴彦祖',
                        phone: '13313131414'
                    }
                }
            }]
        }
    })