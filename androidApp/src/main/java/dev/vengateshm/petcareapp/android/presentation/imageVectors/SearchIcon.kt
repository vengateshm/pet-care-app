package dev.vengateshm.petcareapp.android.presentation.imageVectors

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp


private var _vector: ImageVector? = null

public val SearchIcon: ImageVector
    get() {
        if (_vector != null) {
            return _vector!!
        }
        _vector = ImageVector.Builder(
            name = "vector",
            defaultWidth = 30.dp,
            defaultHeight = 26.dp,
            viewportWidth = 30f,
            viewportHeight = 26f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF4552CB)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(21.4103f, 11.2f)
                curveTo(21.4103f, 15.7287f, 17.7367f, 19.4f, 13.2051f, 19.4f)
                curveTo(8.6736f, 19.4f, 5f, 15.7287f, 5f, 11.2f)
                curveTo(5f, 6.6713f, 8.6736f, 3f, 13.2051f, 3f)
                curveTo(17.7367f, 3f, 21.4103f, 6.6713f, 21.4103f, 11.2f)
                close()
                moveTo(7.05128f, 11.2f)
                curveTo(7.0513f, 14.5965f, 9.8064f, 17.35f, 13.2051f, 17.35f)
                curveTo(16.6038f, 17.35f, 19.359f, 14.5965f, 19.359f, 11.2f)
                curveTo(19.359f, 7.8034f, 16.6038f, 5.05f, 13.2051f, 5.05f)
                curveTo(9.8064f, 5.05f, 7.0513f, 7.8034f, 7.0513f, 11.2f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF4552CB)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(13.2051f, 19.9f)
                curveTo(18.0125f, 19.9f, 21.9103f, 16.0052f, 21.9103f, 11.2f)
                horizontalLineTo(20.9103f)
                curveTo(20.9103f, 15.4523f, 17.4608f, 18.9f, 13.2051f, 18.9f)
                verticalLineTo(19.9f)
                close()
                moveTo(4.5f, 11.2f)
                curveTo(4.5f, 16.0052f, 8.3977f, 19.9f, 13.2051f, 19.9f)
                verticalLineTo(18.9f)
                curveTo(8.9494f, 18.9f, 5.5f, 15.4523f, 5.5f, 11.2f)
                horizontalLineTo(4.5f)
                close()
                moveTo(13.2051f, 2.5f)
                curveTo(8.3977f, 2.5f, 4.5f, 6.3948f, 4.5f, 11.2f)
                horizontalLineTo(5.5f)
                curveTo(5.5f, 6.9477f, 8.9494f, 3.5f, 13.2051f, 3.5f)
                verticalLineTo(2.5f)
                close()
                moveTo(21.9103f, 11.2f)
                curveTo(21.9103f, 6.3948f, 18.0125f, 2.5f, 13.2051f, 2.5f)
                verticalLineTo(3.5f)
                curveTo(17.4608f, 3.5f, 20.9103f, 6.9477f, 20.9103f, 11.2f)
                horizontalLineTo(21.9103f)
                close()
                moveTo(13.2051f, 16.85f)
                curveTo(10.0823f, 16.85f, 7.5513f, 14.3201f, 7.5513f, 11.2f)
                horizontalLineTo(6.55128f)
                curveTo(6.5513f, 14.873f, 9.5306f, 17.85f, 13.2051f, 17.85f)
                verticalLineTo(16.85f)
                close()
                moveTo(18.859f, 11.2f)
                curveTo(18.859f, 14.3201f, 16.328f, 16.85f, 13.2051f, 16.85f)
                verticalLineTo(17.85f)
                curveTo(16.8796f, 17.85f, 19.859f, 14.873f, 19.859f, 11.2f)
                horizontalLineTo(18.859f)
                close()
                moveTo(13.2051f, 5.55f)
                curveTo(16.328f, 5.55f, 18.859f, 8.0799f, 18.859f, 11.2f)
                horizontalLineTo(19.859f)
                curveTo(19.859f, 7.527f, 16.8796f, 4.55f, 13.2051f, 4.55f)
                verticalLineTo(5.55f)
                close()
                moveTo(7.55128f, 11.2f)
                curveTo(7.5513f, 8.0799f, 10.0823f, 5.55f, 13.2051f, 5.55f)
                verticalLineTo(4.55f)
                curveTo(9.5306f, 4.55f, 6.5513f, 7.527f, 6.5513f, 11.2f)
                horizontalLineTo(7.55128f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF4552CB)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF4552CB)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(23.923f, 23.6657f)
                curveTo(24.3132f, 24.0762f, 24.9623f, 24.0928f, 25.373f, 23.703f)
                curveTo(25.7837f, 23.3131f, 25.8004f, 22.6643f, 25.4103f, 22.2539f)
                lineTo(19.7693f, 16.3191f)
                curveTo(19.3791f, 15.9086f, 18.73f, 15.892f, 18.3193f, 16.2818f)
                curveTo(17.9086f, 16.6717f, 17.8919f, 17.3205f, 18.282f, 17.7309f)
                lineTo(23.923f, 23.6657f)
                close()
            }
        }.build()
        return _vector!!
    }