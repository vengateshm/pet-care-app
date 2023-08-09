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

public val ProfileIcon: ImageVector
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
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(23.295f, 22.3159f)
                horizontalLineTo(6.70496f)
                curveTo(6.3055f, 22.3159f, 6f, 22.0104f, 6f, 21.611f)
                curveTo(6f, 16.6292f, 9.1958f, 13.8799f, 15f, 13.8799f)
                curveTo(20.8042f, 13.8799f, 24f, 16.6292f, 24f, 21.611f)
                curveTo(24f, 22.0104f, 23.6945f, 22.3159f, 23.295f, 22.3159f)
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
                moveTo(15f, 12.846f)
                curveTo(12.4151f, 12.846f, 10.3237f, 10.5666f, 10.3237f, 7.7702f)
                curveTo(10.3237f, 5.0444f, 12.3446f, 3f, 15f, 3f)
                curveTo(17.6553f, 3f, 19.6762f, 5.0444f, 19.6762f, 7.7702f)
                curveTo(19.6762f, 10.5666f, 17.5848f, 12.846f, 15f, 12.846f)
                close()
            }
        }.build()
        return _vector!!
    }