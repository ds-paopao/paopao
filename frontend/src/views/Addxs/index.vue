<template>
    <div>
        <el-card class="box-card">
            <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                <el-form-item label="悬赏名" prop="brief">
                    <el-input v-model="ruleForm.brief"></el-input>
                </el-form-item>
                <el-form-item label="悬赏金额" prop="price">
                    <el-input v-model="ruleForm.price"></el-input>
                </el-form-item>
                <el-form-item label="选择时间" required>
                    <el-col :span="24">
                        <el-form-item prop="time">
                            <el-date-picker
                                    v-model="ruleForm.time"
                                    type="datetimerange"
                                    range-separator="至"
                                    start-placeholder="开始日期"
                                    end-placeholder="结束日期">
                            </el-date-picker>
                        </el-form-item>
                    </el-col>
                </el-form-item>
                <el-form-item label="具体描述" prop="context">
                    <el-input type="textarea" v-model="ruleForm.context"></el-input>
                </el-form-item>
                <el-form-item label="拿货地址" prop="address">
                    <el-input v-model="ruleForm.address"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm('ruleForm')">立即发布悬赏</el-button>
                    <el-button @click="resetForm('ruleForm')">重置</el-button>
                </el-form-item>
            </el-form>
        </el-card>

    </div>
</template>

<script>
    export default {
        data() {
            return {
                ruleForm: {
                    brief: '',
                    context: '',
                    price: '',
                    time: '',
                    address: '',
                },
                rules: {
                    brief: [
                        { required: true, message: '请输入悬赏名', trigger: 'brief' }
                    ],
                    time: [
                        { type: 'date', required: true, message: '请选择时间', trigger: 'change' }
                    ],
                    context: [
                        { required: true, message: '请填写具体描述', trigger: 'blur' }
                    ],
                    price: [
                        { required: true, message: '请输入金额', trigger: 'blur' }
                    ],
                    address: [
                        { required: true, message: '请填写拿货地址', trigger: 'blur' }
                    ],
                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        alert('submit!');
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

<style scoped>
    .box-card {

        width: 60%;
        height: 100%;
        margin: 0 auto;
    }
</style>