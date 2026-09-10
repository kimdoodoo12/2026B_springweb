


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