<template>
    <transition name="el-fade-in">
        <div class="page-up"  >
            <i class="el-icon-caret-top"></i>
        </div>
    </transition>
</template>


<script>
    export default {
        name: "scroll",
    }
</script>

<style scoped lang="scss">
    .page-up{
        background-color: #409eff;
        position: fixed;
        right: 50px;
        bottom: 30px;
        width: 40px;
        height: 40px;
        border-radius: 20px;
        cursor: pointer;
        transition: .3s;
        box-shadow: 0 3px 6px rgba(0, 0, 0, .5);
        opacity: .5;
        z-index: 100;
        .el-icon-caret-top{
            color: #fff;
            display: block;
            line-height: 40px;
            text-align: center;
            font-size: 18px;
        }
        p{
            display: none;
            text-align: center;
            color: #fff;
        }
        &:hover{
            opacity: 1;
        }
    }
</style>
