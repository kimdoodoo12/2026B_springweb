


// 1. 변수와 상수
let count = 10;     // let 변수선언 키워드
    count = 3;      // 변수는 수정 가능
const count2 = 20;  // const 상수선언 키워드
    // count2 = 4   // 상수는 수정 불가능 , Uncaught TypeError: Assignment to constant variable.

// 2. 문자열 템플릿, `백틱
console.log(`hello ${count}`);
let html = `<div>
hello ${count2}
</div>
`
console.log(html);

// 3. 조건문, if
const point = 85;
if(point >= 90){console.log('A학점');}
else if(point >= 80){console.log('B학점')}
else{console.log('C학점')}

// 3-2 삼항연산자 , 조건 ? 참 : 거짓 , 조건1? 참1 : 조건2 ? 참2 : 거짓

// 3-3 단축평가 , 조건 && 참이면 결과 , 조건 , 조건 || 거짓이면 결과
console.log(point >= 90 && 'A학점')
console.log(point >= 90 || 'A')

// 3-4: null논리연산 , 조건 ?? null이면 결과
const nickName = null;
console.log(nickName ?? '익명사용자');

// 4. 반목문 :
const array = [10, 20, 30, 40, 50]

// 4-1: 일반 for문
for(let index = 0; index< array.length; index++){console.log(array[index])}

// 4-2 향상된 for문, 반복변수명 in 배열명
for (let index in array){console.log(array[index])} // in 인덱스 하나씩 순회
for (let value of array){console.log(value);}       // of 값 하나씩 순회
// 4-3: forEach , map , filter
array.forEach((value) => {console.log(value)})      // 반환 없음
const newArray = array.map((value)=> {return value})// 반환 있음
const newArray2 = array.filter((value) => {return value >= 20}) // filter 조건에 따른 반환

// 5. 함수: 
// 5-1 : 선언적 함수
function func1(매개변수1, 매개변수2){}
// 5-2 : 익명(이름없는)함수 , 주로 변수/상수에 저장
const func2 = function(매개변수1, 매개변수2){}
// 5-3 : 화살표/람다식 함수 , 주로 변수/상수에 저장
const func3 = (매개변수1, 매개변수2) => { }
// 5-4 : 매개변수에 기본값 대입가능, 만일 인수가 없을 때 기본값 대임
const func4 = (매개변수1, 매개변수2, 매개변수3 = 'student') => { console.log(매개변수3)}
// ---- 함수 호출
func1(4, 10);
func2(4, 20); // 익명 또는 람다 함수는 변수명 호출한다.
func3(10, {name: '유재석'})
func4(10, 4);

// 6. 객체 여러개 값을 가진 하나의 값, 주로 변수/상수에 저장
// 6-1: 속성명(key) : 속성값(value) , 값에는 객체/배열/함수 도 저장 가능
const obj1 = {name: '유재석' , age: '40' , func1: (param)=>{ }}
// 6-2: [값, 값, 값]
const obj2 = ['유재석' , 40, (param)=>{}]
console.log(obj2[2]());     // 인덱스로 속성값 호출

// 7. 스프레드 연산자: ...배열 또는 객체를 복사할 때 사용, 사용처: 주소값 변경 목적 (리액트/플러터)
const obj3 = {...obj1 , phone: "010"} // {...기존객체 , 새로운 속성}
console.log(obj3)
const obj4 = ["010" , ...obj2]      // [...기존배열 , 새로운 값]
console.log(obj4)

// 8. 구조분해 할당: 배열 또는 객체에서 값을 분해해서 각각 변수/상수에 저장
const {name, age} = obj1; // 오른쪽 객체내 왼쪽에 각 변수/상수에 값 대입
console.log(name)
console.log(age)
const [name2, ...array2] = obj2;
console.log(name2)
console.log(array2)

// 9. 콜백함수: 함수 전달해서 나중에 함수 실행 , 메소드레퍼런스
function printSuccess(message){console.log("성공" , message)}
function printScore(score, onSuccess, onError){
    if(score >= 80) {onSuccess("합격")}
    else(onError("불합격"))
}
printScore(50, printSuccess, (message) => {console.log("실패" + message)} )
// 콜백함수 방식으로 함수 호출, 주의할점: 인수에 함수 전달시 함수실행X 함수정의O
// 함수명(3+3); 인수: 6 // 함수명(plus(3,3)) , 인수: 6 // 함수명(plus) , 인수: plus 함수명(plus), 인수: plus함수

// 10. 동기식: 먼저 호출한 함수/ 기능결과가 올때까지 대기상태, 동기화
//  비동기: 먼저 호출한 함수/기능 결과는 순서 상관없이 반환 상태 , axios
// axios 비동기통신이다. 동기화로 만드는방법 (1) 선언함수앞에 async , (2) axios 앞에 await

const backLoad = async( ) => {
    const response = await axios();
}
backLoad();