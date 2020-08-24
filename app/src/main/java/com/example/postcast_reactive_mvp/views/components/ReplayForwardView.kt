package com.example.postcast_reactive_mvp.views.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class ReplayForwardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    val radius = 100f
    val mStroke = 10f


    val mPaint = Paint().apply {
        color = Color.WHITE
        style = Paint.Style.STROKE
        strokeWidth = mStroke
        isAntiAlias = true
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        drawCircle(canvas)
    }

    private fun drawCircle(canvas: Canvas?){

      //  canvas?.drawCircle(width.toFloat()/2,height.toFloat()/2,radius/2,mPaint)
        val diameter = Math.min(width,height)
        val pad = mStroke/2.0f
        val oval = RectF(pad,pad,diameter-pad,diameter-pad)
        canvas?.drawArc(oval,-90f,360f,false,mPaint)

    }
}