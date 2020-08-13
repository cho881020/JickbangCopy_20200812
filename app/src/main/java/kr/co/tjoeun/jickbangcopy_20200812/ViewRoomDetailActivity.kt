package kr.co.tjoeun.jickbangcopy_20200812

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_room_detail.*
import kr.co.tjoeun.jickbangcopy_20200812.datas.Room

class ViewRoomDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_room_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        val room = intent.getSerializableExtra("roomInfo") as Room

        priceTxt.text = room.getFormattedPrice()
        descTxt.text = room.description
        addressTxt.text = room.address

    }

}