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

public val GoogleIcon: ImageVector
    get() {
        if (_vector != null) {
            return _vector!!
        }
        _vector = ImageVector.Builder(
            name = "vector",
            defaultWidth = 90.dp,
            defaultHeight = 90.dp,
            viewportWidth = 30f,
            viewportHeight = 30f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(15.003906f, 3f)
                curveTo(8.3749f, 3f, 3f, 8.373f, 3f, 15f)
                curveTo(3f, 21.627f, 8.3749f, 27f, 15.0039f, 27f)
                curveTo(25.0139f, 27f, 27.2691f, 17.707f, 26.3301f, 13f)
                lineTo(25f, 13f)
                lineTo(22.732422f, 13f)
                lineTo(15f, 13f)
                lineTo(15f, 17f)
                lineTo(22.738281f, 17f)
                curveTo(21.8487f, 20.4483f, 18.726f, 23f, 15f, 23f)
                curveTo(10.582f, 23f, 7f, 19.418f, 7f, 15f)
                curveTo(7f, 10.582f, 10.582f, 7f, 15f, 7f)
                curveTo(17.009f, 7f, 18.8391f, 7.7458f, 20.2441f, 8.9688f)
                lineTo(23.085938f, 6.1289062f)
                curveTo(20.9519f, 4.1849f, 18.1169f, 3f, 15.0039f, 3f)
                close()
            }
        }.build()
        return _vector!!
    }