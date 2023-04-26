<#include "public/header.ftl">




<div id="app">

    <el-form ref="form" :model="form" label-width="80px">

        <el-form-item label="文件类型">
            <el-select v-model="form.region" placeholder="请选择文件类型">
                <el-option label="Clash" value="clash"></el-option>
            </el-select>
        </el-form-item>

        <el-form-item label="规则">
            <el-select v-model="form.resource" placeholder="请选择Clash规则">
                <el-option label="默认" value=""></el-option>
            </el-select>
        </el-form-item>




        <el-form-item label="链接地址">
            <el-input type="textarea"  autosize  placeholder="多个链接回车分开就行" v-model="form.desc"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" :disabled="disables" @click="onSubmit">立即创建</el-button>
            <el-button>取消</el-button>
        </el-form-item>
    </el-form>
    <div v-if="end" style="color: red" >
        {{end}}

    </div>
</div>


<script>
    var app = new Vue({
        el: '#app',
        data: {
            end: '',
            disables: false,
            form: {
                name: '',
                region: 'clash',
                date1: '',
                date2: '',
                delivery: false,
                type: [],
                resource: '',
                desc: ''
            }
        },
        methods: {
            onSubmit() {
                let arr= this.form.desc.split('\n');
                console.log('submit!');
                let request={
                    type: this.form.region,
                    links: arr,
                    outConfig: this.form.resource,
                }
                this.disables=true;
                let that =this;
                axiosRequest('/other/convert/parse', request)
                    .then(function (response) {
                        that.end=response.data;
                        that.$message({
                            message: '请求成功',
                            type: 'success'
                        });
                    })
                    .catch(function (error) {
                        console.log(error);
                    }).finally(res=>{
                    that.disables=false;
                });
            }
        }
    });
</script>

<style>

</style>
<#include "public/tail.ftl">
