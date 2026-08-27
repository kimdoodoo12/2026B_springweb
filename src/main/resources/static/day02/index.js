
console.log("INDEX>JS 열림");
boardFindAll();
async function boardFindAll( ){
    console.log('boardFindAll 열림');


    let tbody = document.querySelector('.boardList');
    let html = "";

    // HTTP통신(AXIOS) 이용한 백엔드에게 요청
    // await axios.HTTP메소드명("HTTP 주소")
    // * 동기화 하는 이유: 해당 통신 이후에 아래 코드 실행하기 위해
    // * 비동기화(요청 후 응답 대기없음) , 동기화 (요청 후 응답대기)

    const response = await axios.get("http://127.0.0.1:8080/board/findAll");
    const responseData = response.data;

    for(let index = 0; index <= responseData.length-1; index++){
        const responseObject = responseData[index];

        html += `<tr>
                    <td> ${responseObject.no} </td> <td> ${responseObject.writer} </td> <td> ${responseObject.content}</td>
                    <td><button onclick="boardUpdate(${responseObject.no})">수정</button> <button onclick="boardDelete(${responseObject.no})">삭제</button></td>
                </tr>`
    }
    console.log(response);

    tbody.innerHTML = html;
}

async function boardSave(){
    const content = document.querySelector('.content').value;
    const writer = document.querySelector('.writer').value;

    const response = await axios.post(`/board/save?content=${content}&writer=${writer}`);

    if (response.data == true){
        alert("저장성공");
        boardFindAll();
    }
}

async function boardUpdate(no){
    const content = prompt("수정할내용");

    const response = await axios.put(`/board/update?no=${no}&content=${content}`);

    if (response.data == true){
        alert("수정성공");
        boardFindAll();
    }else{
        alert("수정 실패")
    }
}

async function boardDelete(no){

    const response = await axios.delete(`/board/delete?no=${no}`);

    if(response.data == true){
        alert("삭제 성공");
        boardFindAll();
    }else{
        alert("수정실패");
    }
}