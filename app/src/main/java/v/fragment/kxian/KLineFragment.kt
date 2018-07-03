package v.fragment.kxian

import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.yyx.R
import kotlinx.android.synthetic.main.fragment_kxian.*
import com.github.mikephil.charting.charts.CandleStickChart
import com.github.mikephil.charting.components.*
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.ViewPortHandler
import other.base.BaseFragment

/**
 * Created by opera on 2018/7/3.
 */

class KLineFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_kxian, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showList(cschart7)
        loadChartData(cschart7)
        cschart7.invalidate()
    }

    private fun showList(mChart:CandleStickChart ) {
        val description = Description()
        description.text = "上证指数"
        description.textColor = Color.RED
        mChart.description = description
        mChart.setDrawGridBackground(true)
        mChart.setBackgroundColor(Color.WHITE)
        mChart.setGridBackgroundColor(Color.WHITE)
        mChart.setScaleYEnabled(false)
        mChart.setPinchZoom(true)
//        mChart.setDrawValueAboveBar(false)
        mChart.setNoDataText("加载中...")
        mChart.setAutoScaleMinMaxEnabled(true)
        mChart.setDragEnabled(true)
        mChart.setMaxVisibleValueCount(50)
//        mChart.setDrawOrder(arrayOf(CombinedChart.DrawOrder.CANDLE, CombinedChart.DrawOrder.LINE))

        val colorLine = Color.GRAY
        val colorText = Color.BLACK
        val xAxis = mChart.getXAxis()
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM)
        xAxis.setDrawGridLines(false)
        xAxis.gridColor = colorLine
        xAxis.setTextColor(colorText)
//        xAxis.setSpaceBetweenLabels(4)

        val yAxis = mChart.getAxisLeft()
        yAxis.setLabelCount(4, false)
        yAxis.setDrawGridLines(true)
        yAxis.setDrawAxisLine(true)
        yAxis.gridColor = colorLine
        yAxis.setTextColor(colorText)

        val rightAxis = mChart.getAxisRight()
        rightAxis.setEnabled(false)

        val colors = intArrayOf(Color.rgb(0,0,0), Color.rgb(0,100,0), Color.rgb(0,0,100))
        val labels = arrayOf("MA5", "MA10", "MA20")
        val legend = mChart.getLegend()
        val cus = ArrayList<LegendEntry>()
        for (it in 0..2){
            val datLegendEntry = LegendEntry()
            datLegendEntry.formColor = colors[it]
            datLegendEntry.label = labels[it]
            cus.add(datLegendEntry)
        }
        legend.setCustom(cus)
        legend.setPosition(Legend.LegendPosition.ABOVE_CHART_RIGHT)
        legend.setTextColor(Color.WHITE)
    }

    private fun loadChartData(mChart:CandleStickChart ) {
        mChart.resetTracking()

        val candleEntries = Model.getCandleEntries()

        val itemcount = candleEntries.size
        val stockBeans = Model.getData()
        val xVals = java.util.ArrayList<String>()
        for (i in 0 until itemcount) {
            xVals.add(stockBeans[i].date)
        }

//        val combinedData = CombinedData()

        /*k line*/
//        val candleData = generateCandleData()
//        combinedData.setData(candleData)

        /*ma5*/
        val ma5Entries = java.util.ArrayList<Entry>()
        for (index in 0 until itemcount) {
            ma5Entries.add(Entry(stockBeans[index].ma5, index.toFloat()))
        }
        /*ma10*/
        val ma10Entries = java.util.ArrayList<Entry>()
        for (index in 0 until itemcount) {
            ma10Entries.add(Entry(stockBeans[index].ma10, index.toFloat()))
        }
        /*ma20*/
        val ma20Entries = java.util.ArrayList<Entry>()
        for (index in 0 until itemcount) {
            ma20Entries.add(Entry(stockBeans[index].ma20, index.toFloat()))
        }

//        val lineData = generateMultiLineData(
//                generateLineDataSet(ma5Entries, colorMa5, "ma5"),
//                generateLineDataSet(ma10Entries, colorMa10, "ma10"),
//                generateLineDataSet(ma20Entries, colorMa20, "ma20"))
//
//        combinedData.setData(lineData)
        mChart.data = generateCandleData()//当前屏幕会显示所有的数据
        mChart.invalidate()
    }

    private fun generateLineDataSet(entries: List<Entry>, color: Int, label: String): LineDataSet {
        val set = LineDataSet(entries, label)
        set.color = color
        set.lineWidth = 1f
//        set.setDrawCubic(true)//圆滑曲线
        set.setDrawCircles(false)
        set.setDrawCircleHole(false)
        set.setDrawValues(false)
        set.isHighlightEnabled = false
        set.axisDependency = YAxis.AxisDependency.LEFT

        return set
    }

    private fun generateMultiLineData(vararg lineDataSets: LineDataSet): LineData {
        val dataSets = java.util.ArrayList<ILineDataSet>()
        for (i in lineDataSets.indices) {
            dataSets.add(lineDataSets[i])
        }
        return LineData(dataSets)
    }

    private fun generateCandleData(): CandleData {

        val set = CandleDataSet(Model.getCandleEntries(), "label")
        set.axisDependency = YAxis.AxisDependency.LEFT
        set.shadowWidth = 0.7f
        set.decreasingColor = Color.RED
        set.decreasingPaintStyle = Paint.Style.FILL
        set.increasingColor = Color.GREEN
        set.increasingPaintStyle = Paint.Style.STROKE
        set.neutralColor = Color.RED
        set.shadowColorSameAsCandle = true
        set.highlightLineWidth = 0.5f
        set.highLightColor = Color.GRAY
        set.setDrawValues(false)

        val candleData = CandleData()
        candleData.addDataSet(set)
        candleData.setValueFormatter(object : IValueFormatter{
            override fun getFormattedValue(value: Float, entry: Entry?, dataSetIndex: Int, viewPortHandler: ViewPortHandler?): String {
                return value.toString()+"元"
            }

        })
        return candleData
    }
}
