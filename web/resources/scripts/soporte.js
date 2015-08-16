
function openModalWindow(url,pRptName,pWidth,pHeight) {
    iWidth=(window.screen.width-pWidth)/2;
    iHeight=(window.screen.height-pHeight)/2;
    var modalWindow =window.open(url,pRptName,"height="+pHeight+",width="+pWidth+",status=no,toolbar=no,menubar=no,location=no,left="+iWidth+",top="+iHeight);
    modalWindow.focus();
} 