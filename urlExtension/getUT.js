//监听点击时间
document.addEventListener('DOMContentLoaded', function() {
    chrome.tabs.query({active:true}, function (tab) {
        document.getElementById('url').value=tab[0].url;            //输入url
        document.getElementById('title').value=tab[0].title;        //输入标题 
    });
});






