
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>添加班级</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link rel="stylesheet" href="../../plugins/layui/css/layui.css" media="all">
	</head>

	<body>
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
			<legend>添加班级</legend>
		</fieldset>
		<div style="display: block; left: 20px; position: absolute;">
			<form class="layui-form layui-form-pane" action="#" method="post" enctype="multipart/form-data">
				<div class="layui-form-item">
					<label class="layui-form-label">修改班级</label>
					<div class="layui-input-inline">
						<input type="text" name="course" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">请务必填写班级名</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">班主任</label>
					<div class="layui-input-inline">
						<input type="text" name="teacher" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<!--<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">验证手机</label>
						<div class="layui-input-inline">
							<input type="tel" name="phone" lay-verify="phone" autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>-->
		
				<!--<div class="layui-form-item">
					<label class="layui-form-label">复选框</label>
					<div class="layui-input-block">
						<input type="checkbox" name="like[write]" title="古典">
						<input type="checkbox" name="like[read]" title="摇滚" checked="">
						<input type="checkbox" name="like[game]" title="经典">
						<input type="checkbox" name="like[game]" title="流行">
						<input type="checkbox" name="like[game]" title="青春">
						<input type="checkbox" name="like[game]" title="游戏">
					</div>
				</div>-->
				
				<div class="layui-form-item">
					<label class="layui-form-label">修改创建时间</label>
					<div class="layui-input-inline">
						<input type="text" name="hour" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<!--<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">文本域</label>
					<div class="layui-input-block">
						<textarea placeholder="请输入内容" class="layui-textarea"></textarea>
					</div>
				</div>-->
				<!--<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">编辑器</label>
					<div class="layui-input-block">
						<textarea class="layui-textarea layui-hide" name="content" lay-verify="content" id="LAY_demo_editor"></textarea>
						<div class="layui-layedit">
							<div class="layui-unselect layui-layedit-tool">
								<i class="layui-icon layedit-tool-b" title="加粗" lay-command="Bold" layedit-event="b" "=" "></i>
								<i class="layui-icon layedit-tool-i " title="斜体 " lay-command="italic " layedit-event="i " "=""></i>
								<i class="layui-icon layedit-tool-u" title="下划线" lay-command="underline" layedit-event="u" "=" "></i>
								<i class="layui-icon layedit-tool-d " title="删除线 " lay-command="strikeThrough " layedit-event="d " "=""></i>
								<span class="layedit-tool-mid"></span>
								<i class="layui-icon layedit-tool-left" title="左对齐" lay-command="justifyLeft" layedit-event="left" "=" "></i>
								<i class="layui-icon layedit-tool-center " title="居中对齐 " lay-command="justifyCenter " layedit-event="center " "=""></i>
								<i class="layui-icon layedit-tool-right" title="右对齐" lay-command="justifyRight" layedit-event="right" "=" "></i>
								<span class="layedit-tool-mid "></span>
								<i class="layui-icon layedit-tool-link " title="插入链接 " layedit-event="link " "=""></i>
								<i class="layui-icon layedit-tool-unlink layui-disabled" title="清除链接" lay-command="unlink" layedit-event="unlink" "=" "></i>
								<i class="layui-icon layedit-tool-face " title="表情 " layedit-event="face " "=""></i>
								<i class="layui-icon layedit-tool-image" title="图片" layedit-event="image">
									<input type="file" name="file">
								</i>
							</div>
							<div class="layui-layedit-iframe"><iframe id="LAY_layedit_1" name="LAY_layedit_1" textarea="LAY_demo_editor" frameborder="0" style="height: 280px;"></iframe></div>
						</div>
					</div>
				</div>-->
				<div class="layui-form-item">
					<button id="but" class="layui-btn" lay-submit="" lay-filter="demo2">提交</button>
				</div>
			</form>
		</div>
		<script src="plugins/layui/layui.js"></script>
		<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
		<script>
			layui.use(['form', 'layedit', 'laydate'], function() {
				var form = layui.form,
					layer = layui.layer,
					layedit = layui.layedit,
					laydate = layui.laydate;

				//日期
				laydate.render({
					elem: '#date'
				});
				laydate.render({
					elem: '#date1'
				});

				//创建一个编辑器
				var editIndex = layedit.build('LAY_demo_editor');

				//自定义验证规则
				form.verify({
					title: function(value) {
						if(value.length < 5) {
							return '标题至少得5个字符啊';
						}
					},
					pass: [/(.+){6,12}$/, '密码必须6到12位'],
					content: function(value) {
						layedit.sync(editIndex);
					}
				});

				//监听指定开关
				form.on('switch(switchTest)', function(data) {
					layer.msg('开关checked：' + (this.checked ? 'true' : 'false'), {
						offset: '6px'
					});
					layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
				});

				//监听提交
				function getCookie(name) {
					var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
					if(arr = document.cookie.match(reg))
						return unescape(arr[2]);
					else
						return null;
				}
				var s1 = getCookie("msg");
				if(s1 == null) {
						s = "添加失败";
						return s;
				} else {
					s=s1;
					return s;
				}
				var s ="asd";
				console.log(data);
				form.on('submit(demo2)', function(msg) {
					layer.alert(JSON.stringify(s), {
						title: '最终的提交信息'
					})
					return false;
				});

			});
		</script>

	</body>

</html>