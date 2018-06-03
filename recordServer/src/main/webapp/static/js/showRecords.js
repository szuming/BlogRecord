function addTime(){
    var fartherTime=new Date();             //第一个为当前时间
    //截取年月日
    fartherTime=fartherTime.getFullYear()+"-"+(fartherTime.getMonth()+1)+"-"+fartherTime.getDate();
    var a;
    a=document.getElementById("rtable");       //获取记录列表
    var i=0;
    for(i=0;i<a.children.length;i++){
        var childTime=a.children[i].children[2].innerText;
        childTime=childTime.split(" ")[0];      //截取年月日
        if(childTime!==fartherTime){  //如果时间不同则添加时间分割节点
            var timeNode=document.createElement("h2");      //创建新节点
            timeNode.innerText=childTime;
            a.insertBefore(timeNode,a.children[i]);
            fartherTime=childTime;
            i++;
        }
    }
}
addTime();