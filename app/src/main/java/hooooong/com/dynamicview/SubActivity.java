package hooooong.com.dynamicview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by Android Hong on 2017-09-16.
 */

public class SubActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
}
