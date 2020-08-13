package kr.co.tjoeun.jickbangcopy_20200812.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kr.co.tjoeun.jickbangcopy_20200812.R
import kr.co.tjoeun.jickbangcopy_20200812.datas.Room
import java.text.NumberFormat
import java.util.*

// trello 카드의 어댑터 뼈대 작업 부분 참고 => 상속 / 생성자 활용
class RoomAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : List<Room>
) : ArrayAdapter<Room>(mContext, resId, mList) {

//    재사용성을 고려한 inflate(xml코드 => 메모리 등록-객체화)를 실행해주는 주체.
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

//        리스트뷰의 재사용성 보존하기위한 null 확인. (어쩔 수 없을때만 inflate)
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = inf.inflate(R.layout.room_list_item, null)
        }

//        재사용성 고려해서 모든 확인이 끝난 상황에서 row로 대입.
        val row = tempRow!!

//        완성된 row에서 필요한 요소들을 코틀린 코드로 받아오기.
//        RecyclerView 활용할때는 작성하지 않는 코드.
        val descTxt = row.findViewById<TextView>(R.id.descTxt)
        val priceTxt = row.findViewById<TextView>(R.id.priceTxt)
        val addressAndFloorTxt = row.findViewById<TextView>(R.id.addressAndFloorTxt)

//        화면에 뿌려질 근거 데이터 / 기능을 갖고있는 변수를 상황에 맞게 가져오자.
//        상황 : getView는 매 줄마다 반복적으로 실행됨 => 어떤 줄을 그리는지? position으로 알아내자.
        val data = mList[position]

//        실제 데이터 화면 반영
        descTxt.text = data.description
        priceTxt.text = data.getFormattedPrice()
        addressAndFloorTxt.text = "${data.address}, ${data.getFormattedFloor()}"

//        반영이 모두 끝난 row를 뿌려달라고 결과로 지정 (return)
        return row
    }

}