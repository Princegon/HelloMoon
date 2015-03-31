package me.letsplaywith.hellomoon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by jinyong on 3/31/15.
 */
public class HelloMoonFragment extends Fragment {

    private Button mPlayBtn, mStopBtn;
    private AudioPlayer mPlayer = new AudioPlayer();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Keep the media player alive when rotating the device
        setRetainInstance(true);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_hello_moon, container, false);

        mPlayBtn = (Button) v.findViewById(R.id.hellomoon_playBtn);
        mPlayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.play(getActivity());
            }
        });

        mStopBtn = (Button) v.findViewById(R.id.hellomoon_stopBtn);
        mStopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.stop();
            }
        });

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
    }
}
