package com.example.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class WuziqiPanel extends View{
    private int mPanelWidth;
    private float mLineHeight;
    private int MAX_LINE = 10;
    private int MAX_COUNT_IN_LINE=5;//

    private Paint mPaint = new Paint();

    private Bitmap mWhitePiece;
    private Bitmap mBlackPiece;

    private float ratioPieceOfLineHeight = 3*1.0f/4;

    //b白棋先手，或当前轮到白棋了
    private boolean mIsWhite = true;
    private ArrayList<Point> mWhiteArray = new ArrayList<>();
    private ArrayList<Point> mBlackArray = new ArrayList<>();

    private boolean mIsGameOver;
    private boolean mIsWhiteWinner;


    public WuziqiPanel(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        setBackgroundColor(0x44ff0000);

        //绘制棋盘棋子
        init();
    }

    private void init() {
        mPaint.setColor(0x88000000);
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setStyle(Paint.Style.STROKE);

        mWhitePiece = BitmapFactory.decodeResource(getResources(),R.drawable.stone_w2);
        mBlackPiece = BitmapFactory.decodeResource(getResources(),R.drawable.stone_b1);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);

        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int width = Math.min(widthSize,heightSize);

        if (widthMode == MeasureSpec.UNSPECIFIED){
            width = heightSize;
        }else  if (heightMode == MeasureSpec.UNSPECIFIED){
            width = widthSize;
        }

        setMeasuredDimension(width,width);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mPanelWidth = w;
        mLineHeight = mPanelWidth *1.0f/MAX_LINE;

        int pieceWidth = (int) (mLineHeight*ratioPieceOfLineHeight);

        mWhitePiece = Bitmap.createScaledBitmap(mWhitePiece,pieceWidth,pieceWidth,false);
        mBlackPiece = Bitmap.createScaledBitmap(mBlackPiece,pieceWidth,pieceWidth,false);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mIsGameOver) return false;//游戏结束

        int action = event.getAction();
        if (action == MotionEvent.ACTION_UP){
            int x = (int) event.getX();
            int y = (int) event.getY();

            Point p = getValidPoint(x,y);

            //判断点击位置是否有棋子，有则不落子
            if (mWhiteArray.contains(p)||mBlackArray.contains(p)){
                return false;
            }

            //true为白棋
            if (mIsWhite){
                mWhiteArray.add(p);
            }else {
                mBlackArray.add(p);
            }
            invalidate();//请求重绘
            mIsWhite=!mIsWhite;

            // return true;
        }
        return true;
        // return super.onTouchEvent(event);
    }

    private Point getValidPoint(int x, int y) {
        return new Point((int)(x/mLineHeight),(int)(y/mLineHeight));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawBoard(canvas);//绘制棋盘
        drawPieces(canvas);//绘制棋子
        checkGameOver();//游戏结束
    }

    private void checkGameOver() {
        boolean whiteWin = checkFiveInLine(mWhiteArray);
        boolean blackWin = checkFiveInLine(mBlackArray);

        if (whiteWin || blackWin){
            mIsGameOver = true;
            mIsWhiteWinner  = whiteWin;

            String text = mIsWhiteWinner?"白棋胜利":"黑棋胜利";

            Toast.makeText(getContext(),text,Toast.LENGTH_SHORT).show();//toast显示输赢
        }
    }
    private boolean checkFiveInLine(List<Point> points) {
        for (Point p : points){
            int x = p.x;
            int y = p.y;

            boolean win  =checkHorizontal(x,y,points);
            if (win) return true;
            win = checkVertical(x,y,points);
            if (win) return true;
            win = checkLeftDiagonal(x,y,points);
            if (win) return true;
            win = checkRightDiagonal(x,y,points);
            if (win) return true;

        }

        return false;
    }

    /**
     * 判断x,y位置棋子，是否“横向”有相邻的五个一致。
     */
    private boolean checkHorizontal(int x, int y, List<Point> points) {
        int count = 1;
        //左
        for (int i = 1;i<MAX_COUNT_IN_LINE;i++){
            if (points.contains(new Point(x - i, y))) {
                count++;
            }else {
                break;
            }
        }
        //判断是否为5，是则胜利
        if (count==MAX_COUNT_IN_LINE) return true;

        //右
        for (int i = 1;i<MAX_COUNT_IN_LINE;i++){
            if (points.contains(new Point(x + i, y))) {
                count++;
            }else {
                break;
            }
        }
        //判断是否为5，是则胜利
        if (count==MAX_COUNT_IN_LINE) return true;
        return false;
    }

    /**
     * 判断x,y位置棋子，是否“纵向”有相邻的五个一致。
     */
    private boolean checkVertical(int x, int y, List<Point> points) {
        int count = 1;
        //上
        for (int i = 1;i<MAX_COUNT_IN_LINE;i++){
            if (points.contains(new Point(x , y-i))) {
                count++;
            }else {
                break;
            }
        }
        //判断是否为5，是则胜利
        if (count==MAX_COUNT_IN_LINE) return true;

        //下
        for (int i = 1;i<MAX_COUNT_IN_LINE;i++){
            if (points.contains(new Point(x , y+i))) {
                count++;
            }else {
                break;
            }
        }
        //判断是否为5，是则胜利
        if (count==MAX_COUNT_IN_LINE) return true;
        return false;
    }

    /**
     * 判断x,y位置棋子，是否“/”有相邻的五个一致。
     */
    private boolean checkLeftDiagonal(int x, int y, List<Point> points) {
        int count = 1;
        //左下
        for (int i = 1;i<MAX_COUNT_IN_LINE;i++){
            if (points.contains(new Point(x-i, y+i))) {
                count++;
            }else {
                break;
            }
        }
        //判断是否为5，是则胜利
        if (count==MAX_COUNT_IN_LINE) return true;

        //右上
        for (int i = 1;i<MAX_COUNT_IN_LINE;i++){
            if (points.contains(new Point(x+i, y-i))) {
                count++;
            }else {
                break;
            }
        }
        //判断是否为5，是则胜利
        if (count==MAX_COUNT_IN_LINE) return true;
        return false;
    }

    /**
     * 判断x,y位置棋子，是否“\”有相邻的五个一致。
     */
    private boolean checkRightDiagonal(int x, int y, List<Point> points) {
        int count = 1;
        //左上
        for (int i = 1;i<MAX_COUNT_IN_LINE;i++){
            if (points.contains(new Point(x-i, y-i))) {
                count++;
            }else {
                break;
            }
        }
        //判断是否为5，是则胜利
        if (count==MAX_COUNT_IN_LINE) return true;

        //右下
        for (int i = 1;i<MAX_COUNT_IN_LINE;i++){
            if (points.contains(new Point(x+i, y+i))) {
                count++;
            }else {
                break;
            }
        }
        //判断是否为5，是则胜利
        if (count==MAX_COUNT_IN_LINE) return true;
        return false;
    }


    private void drawPieces(Canvas canvas) {
        //绘制白子
        for (int i = 0,n=mWhiteArray.size();i<n;i++){
            Point whitePoint = mWhiteArray.get(i);
            canvas.drawBitmap(mWhitePiece,
                    (whitePoint.x+(1-ratioPieceOfLineHeight)/2)*mLineHeight,
                    (whitePoint.y+(1-ratioPieceOfLineHeight)/2)*mLineHeight,
                    null);
        }
        //绘制黑子
        for (int i = 0,n=mBlackArray.size();i<n;i++){
            Point blackPoint = mBlackArray.get(i);
            canvas.drawBitmap(mBlackPiece,
                    (blackPoint.x+(1-ratioPieceOfLineHeight)/2)*mLineHeight,
                    (blackPoint.y+(1-ratioPieceOfLineHeight)/2)*mLineHeight,
                    null);
        }

    }

    private void drawBoard(Canvas canvas) {
        int w = mPanelWidth;
        float lineHeight = mLineHeight;

        for (int i=0;i<MAX_LINE;i++){
            int startX = (int) (lineHeight/2);
            int endx = (int) (w-lineHeight/2);
            int y = (int) ((0.5 + i)*lineHeight);
            //绘制横线
            canvas.drawLine(startX,y,endx,y,mPaint);
            //绘制纵线
            canvas.drawLine(y,startX,y,endx,mPaint);
        }
    }

    //再来一局
    public void  start(){
        mWhiteArray.clear();
        mBlackArray.clear();
        mIsGameOver = false;
        mIsWhiteWinner =false;
        invalidate();
    }

    /**
     * View的存储与恢复
     *
     */
    private static final String INSTANCE = "instance";
    private static final String INSTANCE_GAME_OVER = "intstance_game_over";
    private static final String INSTANCE_WHITE_ARRAY = "intstance_white_array";
    private static final String INSTANCE_BLACK_ARRAY = "intstance_black_array";

    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(INSTANCE,super.onSaveInstanceState());
        bundle.putBoolean(INSTANCE_GAME_OVER,mIsGameOver);
        bundle.putParcelableArrayList(INSTANCE_WHITE_ARRAY,mWhiteArray);
        bundle.putParcelableArrayList(INSTANCE_BLACK_ARRAY,mBlackArray);
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof  Bundle){
            Bundle bundle = (Bundle) state;
            mIsGameOver = bundle.getBoolean(INSTANCE_GAME_OVER);
            mWhiteArray = bundle.getParcelableArrayList(INSTANCE_WHITE_ARRAY);
            mBlackArray = bundle.getParcelableArrayList(INSTANCE_BLACK_ARRAY);
            super.onRestoreInstanceState(bundle.getParcelable(INSTANCE));
            return;
        }
        super.onRestoreInstanceState(state);
    }
}

