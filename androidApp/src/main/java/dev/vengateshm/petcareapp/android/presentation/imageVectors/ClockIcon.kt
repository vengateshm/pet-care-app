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

public val ClockIcon: ImageVector
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
                moveTo(15f, 3f)
                curveTo(9.4783f, 3f, 5f, 7.4783f, 5f, 13f)
                curveTo(5f, 18.5217f, 9.4783f, 23f, 15f, 23f)
                curveTo(20.5217f, 23f, 25f, 18.5217f, 25f, 13f)
                curveTo(25f, 7.4783f, 20.5217f, 3f, 15f, 3f)
                close()
                moveTo(18.3261f, 15.087f)
                curveTo(18.6739f, 15.4348f, 18.6739f, 15.9783f, 18.3261f, 16.3261f)
                curveTo(18.1522f, 16.5f, 17.9348f, 16.587f, 17.7174f, 16.587f)
                curveTo(17.5f, 16.587f, 17.2826f, 16.5f, 17.1087f, 16.3261f)
                lineTo(14.4131f, 13.6304f)
                curveTo(14.2391f, 13.4565f, 14.1522f, 13.2392f, 14.1522f, 13.0218f)
                verticalLineTo(7.84784f)
                curveTo(14.1522f, 7.3696f, 14.5435f, 6.9783f, 15.0217f, 6.9783f)
                curveTo(15.5f, 6.9783f, 15.8913f, 7.3696f, 15.8913f, 7.8478f)
                verticalLineTo(12.6739f)
                lineTo(18.3261f, 15.087f)
                close()
            }
        }.build()
        return _vector!!
    }