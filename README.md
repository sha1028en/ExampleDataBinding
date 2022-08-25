# ExampleDataBinding
안드로이드 데이터 바인딩 학습...<br>

MVVM을 배우기 전에 먼저 보는 데이터 바인딩.<br>
데이터가 변경돼면, 화면( XML)의 값도 별도 처리 없이 알아서 바뀌는 마법.


## build.gradle
  ```
android {
    compileSdk nn

    dataBinding { enabled = true }
    . . . 
 ```
을 적어주고 sync now를 해주자.


## 화면.xml
```
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>
        <variable
            name="state"
            type="com.example.exampledatabinding.State" />
    </data>


    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">
          . . . 
          android:text="@{ state.cnt}"
```
- 최상단 레이아웃을 layoyut으로 해줘야 한다
- data 항목에서 해당 파일에서 사용할 객체명 name.
- data 항목에서 해당 파일에 적용할 데이터 경로. type
- View 에서 가변적으로 값을 적용할 @{ 객체명.프로퍼티 } 

## POJO
```data class State( val cnt: String) ```

## 코틀린
```     private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.bind = DataBindingUtil.setContentView( this, R.layout.activity_main)
        this.bind.state = 값
```
바인딩 객체의 state 객체를 변경하면 화면의 값도 알아서 바뀐다.
( 레이아웃을 작업 안해주면 바인딩 객체가 안붙는다! )

## 결과
![Android Emulator - ExampleDataBinding 2022-08-24 14-22-28_1](https://user-images.githubusercontent.com/100817401/186336585-f0bd5372-8f75-43a2-955b-9a78e12354f8.gif)

따로 TxtView 값을 갱신하는 코드를 안해줘도 값이 바뀌지만.
위 코드로는 화면 전환시 값을 잃어버린다...

