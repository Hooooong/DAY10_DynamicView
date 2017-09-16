Android Programing
----------------------------------------------------
#### 2017.09.15 4일차

###### 예제
____________________________________________________

  - [Dummy 생성 및 애니메이션]()

###### 공부정리
____________________________________________________

  - Android ViewGroup 및 View 생성

      1. XML로 설정

          - Android는 Activity 에 적용시킬 View들을 XML로 설정할 수 있다.
          - 간편하게 설정 가능하고, id를 통해 View 들을 관리한다.

          - activity_main.xml

              ```xml
              <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
                  xmlns:tools="http://schemas.android.com/tools"
                  android:layout_width="match_parent"
                  android:layout_height="match_parent"
                  tools:context="hooooong.com.dynamicview.MainActivity"
                  android:orientation="vertical">

                  <Button
                      android:id="@+id/btnSubActivity"
                      android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                      android:text="동적Activity 생성"/>

              </LinearLayout>
              ```
          - MainActivity.java

              ```java
              @Override
              protected void onCreate(Bundle savedInstanceState) {
                  super.onCreate(savedInstanceState);
                  setContentView(R.layout.activity_main);

                  Button btnSubActivity = (Button)findViewById(R.id.btnSubActivity);
              }            
              ```

      2. Java Code 로 설정

          - 동적으로 ViewGroup 과 View 를 생성할 수 있다.
          - XML 코드를 작성하지 않아도 View 를 작성할 수 있다.

          - SubActivity.java
              ```java
              @Override
              protected void onCreate(Bundle savedInstanceState) {
                 super.onCreate(savedInstanceState);

                 // LinearLayout 생성
                 LinearLayout linearLayout = new LinearLayout(this);

                 // Layout 의 속성을 변경한다. ( LinearLayout 의 Orientation 속성을 VERTICAL 로)
                 linearLayout.setOrientation(LinearLayout.VERTICAL);
                 // Layout 의 BackgroundColor 변경
                 linearLayout.setBackgroundColor(Color.GRAY);

                 // 버튼을 코드로 생성
                 Button player = new Button(this);

                 // 버튼의 width 설정
                 player.setWidth(30);
                 // 버튼의 height 설정
                 player.setHeight(100);
                 // 버튼의 텍스트 설정
                 player.setText("P");

                 // 버튼을 코드로 생성
                 Button player2 = new Button(this);
                 // 버튼의 BackgroundColor 설정
                 player2.setBackgroundColor(Color.RED);
                 // 버튼의 width 설정
                 player2.setWidth(100);
                 // 버튼의 height 설정
                 player2.setHeight(100);
                 // 버튼의 텍스트 설정
                 player2.setText("P2");

                 // 컨테이너에 뷰를 넣는다.
                 //stage.addView(player);
                 //stage.addView(player2);

                 /**
                  * 동적으로 View 를 생성할 경우 자신이 담길 ViewGroup 을 모르기 때문에
                  * View 의 Width, Height 가 담길 ViewGroup 의 설정. 즉, 부모의 Layout 에 맞춰지기 때문에
                  * 설정을 해줘도 적용이 되지 않는다.
                  *
                  * 그럴 경우에는 ViewGroup.LayoutParams 를 생성하여
                  * ViewGroup 에 View 들을 어떻게 배치할지 지시해야 한다.
                  *
                  * 즉, layout_width, layout_height 를 설정하는 것과 동일하다.
                  *
                  */

                 LinearLayout.LayoutParams vl1 = new LinearLayout.LayoutParams(250, 500);
                 LinearLayout.LayoutParams vl2 = new LinearLayout.LayoutParams(500, 500);

                 // view 에 setLayoutParams 를 설정한다.
                 // 이렇게 되면 player 의 ViewGroup 에 있는
                 player.setLayoutParams(vl1);
                 player2.setLayoutParams(vl2);

                 linearLayout.addView(player);
                 linearLayout.addView(player2);

                 // OR
                 // addView 의 parameter 에 추가한다.

                 //stage.addView(player);
                 //stage.addView(player2);

                 setContentView(linearLayout);
              }
              ```
