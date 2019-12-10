import Mock from 'mockjs'


    Mock.mock('http://localhost:8080/user/login', {
        'code': 1,
        'msg':'登录成功',
        'data':{}
    })
