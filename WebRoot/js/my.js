// JavaScript Document
function show(d) {
        document.getElementById(d).style.visibility='visible';
    }
function hide(d){
        document.getElementById(d).style.visibility='hidden';
}
//购物车
function buttonSubmit(address){
	$("#form").action=address;
	$("#form").submit();

}
function num_del(){
	if(document.getElementById("addnum").value>1){
		--document.getElementById("addnum").value;
	}
}
function num_add(){
	a=$("#kucun").text()*1;
	if(document.getElementById("addnum").value<a){
	++document.getElementById("addnum").value;
	}
}
function checknum(obj){
	b=$("#kucun").text()*1;
	if(obj.value>b){
		obj.value=b;
	}
}

function checkcount(obj){
	c=$("#winecount").text()*1;
	if(obj.value>c){
		obj.value=c;
	}
}

function buttonUpdate(addres){
	$("#cartform").action=addres;
	$("#cartform").submit();

}

/*支付提示*/
function suretopay(){
	if(confirm("现在支付！")){
		alter("确定");
	}else{
		alter("取消");
	}
}
