package com.ckkj.zct.baselibrary.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.ImageView
import com.ckkj.zct.baselibrary.R
import android.graphics.drawable.Drawable
import android.graphics.Bitmap
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.BitmapDrawable
import android.graphics.Shader
import android.graphics.BitmapShader



/**
 * @author zct
 * Created by zct11 on 2018/1/25.
 * 绘制圆形头像
 */
class CircleImageView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {

    /**
     * 圆形头像默认，CENTER_CROP!=系统默认的CENTER_CROP；
     * 将图片等比例缩放，让图像的长边边与ImageView的边长度相同，短边不够的留空白，缩放后截取圆形部分进行显示。
     */
    private val SCALE_TYPE = ImageView.ScaleType.CENTER_CROP
    /**
     * 图片的压缩质量
     * ALPHA_8就是Alpha由8位组成，------ALPHA_8 代表8位Alpha位图
     * ARGB_4444就是由4个4位组成即16位，------ARGB_4444 代表16位ARGB位图
     * ARGB_8888就是由4个8位组成即32位，------ARGB_8888 代表32位ARGB位图
     * RGB_565就是R为5位，G为6位，B为5位共16位，------ARGB_565 代表8位RGB位图
     */
    private val BITMAP_CONFIG = Bitmap.Config.ARGB_8888
    /**
     * 默认ColorDrawable的宽和高
     */
    private val COLORDRAWABLE_DIMENSION = 1
    /**
     * 默认边框宽度
     */
    private val DEFAULT_BORDER_WIDTH = 0
    /**
     * 默认边框颜色
     */
    private val DEFAULT_BORDER_COLOR = Color.BLACK
    /**
     * 画图片的矩形
     */
    private val mDrawableRect = RectF()
    /**
     * 画边框的矩形
     */
    private val mBorderRect = RectF()
    /**
     * 对图片进行缩放和移动的矩阵
     */
    private val mShaderMatrix = Matrix()
    /**
     * 画图片的画笔
     */
    private val mBitmapPaint = Paint()
    /**
     * 画边框的画笔
     */
    private val mBorderPaint = Paint()
    /**
     * 默认边框颜色
     */
    private var mBorderColor = DEFAULT_BORDER_COLOR
    /**
     * 默认边框宽度
     */
    private var mBorderWidth = DEFAULT_BORDER_WIDTH

    private var mBitmap: Bitmap? = null
    /**
     * 产生一个画有一个位图的渲染器（Shader）
     */
    private var mBitmapShader: BitmapShader? = null
    /**
     * 图片的实际宽度
     */
    private var mBitmapWidth: Int = 0
    /**
     * 图片实际高度
     */
    private var mBitmapHeight: Int = 0
    /**
     * 图片半径
     */
    private var mDrawableRadius: Float = 0.toFloat()
    /**
     * 边框半径
     */
    private var mBorderRadius: Float = 0.toFloat()
    /**
     * 是否初始化准备好
     */
    private var mReady: Boolean = false
    /**
     * 内边距
     */
    private var mSetupPending: Boolean = false

    init {
        /*获取xml对应属性*/
       val cv=context.obtainStyledAttributes(attrs,R.styleable.CircleImageView)
        mBorderWidth=cv.getDimensionPixelSize(R.styleable.CircleImageView_civ_border_width,DEFAULT_BORDER_WIDTH)
        mBorderColor=cv.getColor(R.styleable.CircleImageView_civ_border_color,DEFAULT_BORDER_COLOR)
        cv.recycle()

        mReady=true

        if(mSetupPending){
            setup()
            mSetupPending=false
        }

    }

    override fun getScaleType(): ScaleType {
        return SCALE_TYPE
    }

    override fun onDraw(canvas: Canvas?) {
        if (getDrawable() == null) {
            return
        }
        /**
         * 画圆形图片
         */
        canvas?.drawCircle((getWidth() / 2).toFloat(), (getHeight() / 2).toFloat(), mDrawableRadius, mBitmapPaint)
        /**
         * 画圆形边框
         */
        canvas?.drawCircle((getWidth() / 2).toFloat(), (getHeight() / 2).toFloat(), mBorderRadius, mBorderPaint)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        setup()
    }

    /**
     * 获取边框颜色
     *
     * @return
     */
    fun getBorderColor(): Int {
        return mBorderColor
    }

    /**
     * 设置边框颜色
     *
     * @param borderColor
     */
    fun setBorderColor(borderColor: Int) {
        if (borderColor == mBorderColor) {
            return
        }

        mBorderColor = borderColor
        mBorderPaint.color = mBorderColor
        invalidate()
    }

    /**
     * 获取边框宽度
     *
     * @return
     */
    fun getBorderWidth(): Int {
        return mBorderWidth
    }

    /**
     * 设置边框宽度
     *
     * @param borderWidth
     */
    fun setBorderWidth(borderWidth: Int) {
        if (borderWidth == mBorderWidth) {
            return
        }

        mBorderWidth = borderWidth
        setup()
    }

    /**
     * 设置资源图片
     *
     * @param bm
     */
    override fun setImageBitmap(bm: Bitmap) {
        super.setImageBitmap(bm)
        mBitmap = bm
        setup()
    }

    /**
     * 设置资源图片
     *
     * @param drawable
     */
    override fun setImageDrawable(drawable: Drawable?) {
        super.setImageDrawable(drawable)
        mBitmap = getBitmapFromDrawable(drawable)
        setup()
    }

    /**
     * 设置资源id
     *
     * @param resId
     */
    override fun setImageResource(resId: Int) {
        super.setImageResource(resId)
        mBitmap = getBitmapFromDrawable(drawable)
        setup()
    }

    /**
     * 获取资源图片
     *
     * @param drawable
     * @return
     */
    private fun getBitmapFromDrawable(drawable: Drawable?): Bitmap? {
        if (drawable == null) {
            return null
        }

        if (drawable is BitmapDrawable) {
            return drawable.bitmap
        }

        try {
            val bitmap: Bitmap

            if (drawable is ColorDrawable) {
                bitmap = Bitmap.createBitmap(COLORDRAWABLE_DIMENSION, COLORDRAWABLE_DIMENSION, BITMAP_CONFIG)
            } else {
                bitmap = Bitmap.createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight, BITMAP_CONFIG)
            }

            val canvas = Canvas(bitmap)
            drawable.setBounds(0, 0, canvas.width, canvas.height)
            drawable.draw(canvas)
            return bitmap
        } catch (e: OutOfMemoryError) {
            return null
        }

    }

    /**
     * 画圆形图的方法
     */
    private fun setup() {
        if (!mReady) {
            mSetupPending = true
            return
        }

        if (mBitmap == null) {
            return
        }
        /**
         * 调用这个方法来产生一个画有一个位图的渲染器（Shader）。
         * bitmap   在渲染器内使用的位图
         * tileX      The tiling mode for x to draw the bitmap in.   在位图上X方向花砖模式
         * tileY     The tiling mode for y to draw the bitmap in.    在位图上Y方向花砖模式
         * TileMode：（一共有三种）
         * CLAMP  ：如果渲染器超出原始边界范围，会复制范围内边缘染色。
         * REPEAT ：横向和纵向的重复渲染器图片，平铺。
         * MIRROR ：横向和纵向的重复渲染器图片，这个和REPEAT 重复方式不一样，他是以镜像方式平铺。
         */
        mBitmapShader = BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        /**
         * 设置画圆形的画笔
         */
        mBitmapPaint.isAntiAlias = true//设置抗锯齿
        mBitmapPaint.shader = mBitmapShader//绘制图形时的图形变换

        mBorderPaint.style = Paint.Style.STROKE
        mBorderPaint.isAntiAlias = true
        mBorderPaint.color = mBorderColor
        mBorderPaint.setStrokeWidth(mBorderWidth.toFloat())

        mBitmapHeight = mBitmap!!.getHeight()
        mBitmapWidth = mBitmap!!.getWidth()
        /**
         * 设置边框矩形的坐标
         */
        mBorderRect.set(0F, 0F, width.toFloat(), height.toFloat())
        /**
         * 设置边框圆形的半径为图片的宽度和高度的一半的最大值
         */
        mBorderRadius = Math.max((mBorderRect.height() - mBorderWidth) / 2, (mBorderRect.width() - mBorderWidth) / 2)
        /**
         * 设置图片矩形的坐标
         */
        mDrawableRect.set(mBorderWidth.toFloat(), mBorderWidth.toFloat(), mBorderRect.width() - mBorderWidth, mBorderRect.height() - mBorderWidth)
        /**
         * 设置图片圆形的半径为图片的宽度和高度的一半的最大值
         */
        mDrawableRadius = Math.max(mDrawableRect.height() / 2, mDrawableRect.width() / 2)

        updateShaderMatrix()
        /**
         * 调用onDraw()方法进行绘画
         */
        invalidate()
    }

    /**
     * 更新位图渲染
     */
    private fun updateShaderMatrix() {
        val scale: Float
        var dx = 0f
        var dy = 0f
        /**
         * 重置
         */
        mShaderMatrix.set(null)
        /**
         * 计算缩放比，因为如果图片的尺寸超过屏幕，那么就会自动匹配到屏幕的尺寸去显示。
         * 确定移动的xy坐标
         *
         */
        if (mBitmapWidth * mDrawableRect.height() > mDrawableRect.width() * mBitmapHeight) {
            scale = mDrawableRect.width() / mBitmapWidth as Float
            dy = (mDrawableRect.height() - mBitmapHeight * scale) * 0.5f
        } else {
            scale = mDrawableRect.height() / mBitmapHeight as Float
            dx = (mDrawableRect.width() - mBitmapWidth * scale) * 0.5f
        }

        mShaderMatrix.setScale(scale, scale)
        mShaderMatrix.postTranslate(((dx + 0.5f).toInt() + mBorderWidth).toFloat(), ((dy + 0.5f).toInt() + mBorderWidth).toFloat())
        /**
         * 设置shader的本地矩阵
         */
        mBitmapShader!!.setLocalMatrix(mShaderMatrix)
    }
}