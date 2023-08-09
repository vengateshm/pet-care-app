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

public val ArrowRight: ImageVector
    get() {
        if (_vector != null) {
            return _vector!!
        }
        _vector = ImageVector.Builder(
            name = "vector",
            defaultWidth = 8.dp,
            defaultHeight = 13.dp,
            viewportWidth = 8f,
            viewportHeight = 13f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFBBC3CE)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(0f, 1.37054f)
                lineTo(1.39309f, 0f)
                lineTo(8f, 6.5f)
                lineTo(1.39309f, 13f)
                lineTo(0f, 11.6295f)
                lineTo(5.21383f, 6.5f)
                lineTo(0f, 1.37054f)
                close()
            }
        }.build()
        return _vector!!
    }