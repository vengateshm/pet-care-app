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

public val MyPetsIcon: ImageVector
    get() {
        if (_vector != null) {
            return _vector!!
        }
        _vector = ImageVector.Builder(
            name = "vector",
            defaultWidth = 19.dp,
            defaultHeight = 19.dp,
            viewportWidth = 19f,
            viewportHeight = 19f
        ).apply {
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF4552CB)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(10.2876f, 8.58708f)
                lineTo(10.2873f, 8.58676f)
                curveTo(10.2267f, 8.526f, 10.1929f, 8.4988f, 10.1177f, 8.4404f)
                lineTo(10.1166f, 8.43954f)
                curveTo(9.9005f, 8.2711f, 9.6346f, 8.1577f, 9.2972f, 8.1088f)
                lineTo(9.29683f, 8.10871f)
                curveTo(9.1667f, 8.0898f, 9.0092f, 8.0821f, 8.8089f, 8.0851f)
                lineTo(10.2876f, 8.58708f)
                close()
                moveTo(10.2876f, 8.58708f)
                curveTo(10.6199f, 8.9197f, 10.8283f, 9.2653f, 10.9286f, 9.5882f)
                lineTo(10.9286f, 9.58836f)
                curveTo(11.0295f, 9.9129f, 11.0566f, 10.2948f, 10.9668f, 10.8722f)
                curveTo(10.9362f, 11.0646f, 10.898f, 11.239f, 10.7895f, 11.7337f)
                curveTo(10.7819f, 11.7684f, 10.7739f, 11.8048f, 10.7656f, 11.8428f)
                lineTo(10.7655f, 11.8431f)
                curveTo(10.615f, 12.5311f, 10.5498f, 12.8867f, 10.5014f, 13.3234f)
                lineTo(10.5013f, 13.3242f)
                curveTo(10.4503f, 13.7881f, 10.4377f, 14.1676f, 10.467f, 14.6549f)
                lineTo(10.467f, 14.6554f)
                curveTo(10.4916f, 15.0595f, 10.4789f, 15.4128f, 10.431f, 15.75f)
                curveTo(10.3305f, 16.4575f, 10.0859f, 17.0282f, 9.7409f, 17.4583f)
                lineTo(9.74078f, 17.4585f)
                curveTo(9.6685f, 17.5486f, 9.6346f, 17.5902f, 9.566f, 17.6586f)
                lineTo(9.56544f, 17.6592f)
                curveTo(9.4571f, 17.7675f, 9.3969f, 17.8188f, 9.2936f, 17.8923f)
                lineTo(9.29168f, 17.8937f)
                curveTo(9.0004f, 18.1025f, 8.672f, 18.2204f, 8.313f, 18.2472f)
                lineTo(8.30853f, 18.2475f)
                curveTo(8.3095f, 18.2474f, 8.2969f, 18.2483f, 8.267f, 18.249f)
                curveTo(8.2402f, 18.2497f, 8.2081f, 18.25f, 8.1747f, 18.25f)
                curveTo(8.1413f, 18.25f, 8.1093f, 18.2497f, 8.0828f, 18.249f)
                curveTo(8.0589f, 18.2484f, 8.0465f, 18.2478f, 8.0434f, 18.2476f)
                curveTo(8.0426f, 18.2476f, 8.0424f, 18.2476f, 8.0427f, 18.2476f)
                lineTo(8.03797f, 18.2472f)
                curveTo(7.6223f, 18.2158f, 7.2643f, 18.0853f, 6.992f, 17.8918f)
                curveTo(6.9208f, 17.8412f, 6.902f, 17.8276f, 6.8803f, 17.8096f)
                curveTo(6.8595f, 17.7924f, 6.8274f, 17.7637f, 6.751f, 17.688f)
                lineTo(6.74939f, 17.6864f)
                curveTo(6.7027f, 17.6404f, 6.6641f, 17.5978f, 6.6409f, 17.5719f)
                curveTo(6.6186f, 17.544f, 6.5956f, 17.5168f, 6.5844f, 17.5037f)
                lineTo(6.5833f, 17.5024f)
                curveTo(6.5129f, 17.4202f, 6.4084f, 17.2874f, 6.3318f, 17.1741f)
                curveTo(6.2112f, 16.9943f, 6.1247f, 16.8434f, 5.86f, 16.3757f)
                lineTo(5.85994f, 16.3757f)
                curveTo(5.6312f, 15.9717f, 5.5237f, 15.7943f, 5.4026f, 15.6025f)
                moveTo(10.2876f, 8.58708f)
                lineTo(0.85427f, 11.572f)
                moveTo(7.08431f, 8.30422f)
                lineTo(7.08426f, 8.30422f)
                curveTo(6.2795f, 8.4444f, 5.8527f, 8.5021f, 5.3721f, 8.5338f)
                lineTo(5.37207f, 8.53378f)
                curveTo(5.0214f, 8.5569f, 4.7026f, 8.5584f, 4.3404f, 8.5337f)
                lineTo(4.34016f, 8.53365f)
                curveTo(3.7062f, 8.4902f, 3.1321f, 8.5586f, 2.6156f, 8.728f)
                curveTo(2.169f, 8.8751f, 1.8068f, 9.0797f, 1.5046f, 9.3442f)
                lineTo(1.50289f, 9.34566f)
                lineTo(1.50289f, 9.34566f)
                curveTo(1.4886f, 9.3581f, 1.4453f, 9.3989f, 1.3901f, 9.4541f)
                curveTo(1.3649f, 9.4793f, 1.3407f, 9.504f, 1.3206f, 9.5251f)
                curveTo(1.3106f, 9.5355f, 1.3022f, 9.5444f, 1.2956f, 9.5516f)
                lineTo(1.28796f, 9.55997f)
                curveTo(1.2862f, 9.5619f, 1.2854f, 9.5629f, 1.2853f, 9.563f)
                curveTo(1.2853f, 9.563f, 1.2853f, 9.563f, 1.2853f, 9.563f)
                lineTo(1.28288f, 9.56577f)
                lineTo(1.28287f, 9.56577f)
                curveTo(0.9892f, 9.9024f, 0.8238f, 10.2563f, 0.7696f, 10.642f)
                lineTo(7.08431f, 8.30422f)
                close()
                moveTo(7.08431f, 8.30422f)
                curveTo(7.6965f, 8.1976f, 7.9095f, 8.1642f, 8.1689f, 8.1316f)
                moveTo(7.08431f, 8.30422f)
                lineTo(8.16888f, 8.13155f)
                moveTo(0.85427f, 11.572f)
                lineTo(0.854419f, 11.5724f)
                curveTo(0.9874f, 11.9261f, 1.2459f, 12.253f, 1.8479f, 12.6582f)
                lineTo(1.84917f, 12.659f)
                curveTo(2.0372f, 12.7861f, 2.2923f, 12.9448f, 2.7304f, 13.193f)
                lineTo(2.73146f, 13.1936f)
                curveTo(3.3772f, 13.561f, 3.7524f, 13.8006f, 4.0846f, 14.0658f)
                curveTo(4.5749f, 14.4572f, 4.9977f, 14.9578f, 5.4026f, 15.6025f)
                moveTo(0.85427f, 11.572f)
                curveTo(0.7624f, 11.328f, 0.7232f, 10.974f, 0.7695f, 10.6424f)
                lineTo(0.85427f, 11.572f)
                close()
                moveTo(5.4026f, 15.6025f)
                curveTo(5.4024f, 15.6022f, 5.4022f, 15.6018f, 5.402f, 15.6015f)
                lineTo(4.7678f, 16.002f)
                lineTo(5.40295f, 15.6031f)
                curveTo(5.4028f, 15.6029f, 5.4027f, 15.6027f, 5.4026f, 15.6025f)
                close()
                moveTo(8.16888f, 8.13155f)
                curveTo(8.4082f, 8.1018f, 8.6161f, 8.088f, 8.8088f, 8.0851f)
                lineTo(8.16888f, 8.13155f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF4552CB)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(12.4887f, 4.44762f)
                lineTo(12.4887f, 4.44759f)
                curveTo(12.8879f, 3.9131f, 13.0975f, 3.3169f, 13.1152f, 2.7591f)
                curveTo(13.1243f, 2.4561f, 13.0638f, 2.1863f, 12.9644f, 1.9892f)
                lineTo(12.9643f, 1.98912f)
                curveTo(12.86f, 1.7823f, 12.7026f, 1.6272f, 12.5229f, 1.5368f)
                curveTo(12.4178f, 1.4841f, 12.312f, 1.4517f, 12.1634f, 1.4355f)
                curveTo(12.1601f, 1.4354f, 12.1502f, 1.4349f, 12.132f, 1.4344f)
                curveTo(12.1059f, 1.4338f, 12.0734f, 1.4334f, 12.0393f, 1.4333f)
                curveTo(12.0052f, 1.4333f, 11.9725f, 1.4337f, 11.9459f, 1.4344f)
                curveTo(11.9213f, 1.435f, 11.9108f, 1.4357f, 11.9108f, 1.4356f)
                curveTo(11.5589f, 1.4695f, 11.1622f, 1.63f, 10.7768f, 1.9292f)
                curveTo(10.7134f, 1.9787f, 10.688f, 2.0001f, 10.6619f, 2.0238f)
                curveTo(10.6296f, 2.0535f, 10.5912f, 2.0914f, 10.501f, 2.1815f)
                curveTo(10.4886f, 2.194f, 10.4769f, 2.2056f, 10.4659f, 2.2166f)
                curveTo(10.3187f, 2.3639f, 10.2967f, 2.3859f, 10.217f, 2.4884f)
                curveTo(9.6652f, 3.1997f, 9.4668f, 4.0275f, 9.5957f, 4.6498f)
                lineTo(9.5959f, 4.651f)
                curveTo(9.6438f, 4.884f, 9.7386f, 5.0714f, 9.8649f, 5.2185f)
                curveTo(9.8661f, 5.2198f, 9.8692f, 5.223f, 9.8745f, 5.2283f)
                curveTo(9.8842f, 5.2381f, 9.8969f, 5.2504f, 9.9112f, 5.2639f)
                curveTo(9.9254f, 5.2772f, 9.9395f, 5.2902f, 9.9519f, 5.3012f)
                curveTo(9.9651f, 5.313f, 9.9727f, 5.3194f, 9.9744f, 5.3209f)
                lineTo(9.49914f, 5.90101f)
                moveTo(12.4887f, 4.44762f)
                lineTo(10.4826f, 5.53384f)
                curveTo(10.4607f, 5.5311f, 10.4208f, 5.5252f, 10.3795f, 5.5178f)
                curveTo(10.3594f, 5.5142f, 10.342f, 5.5108f, 10.3284f, 5.5079f)
                curveTo(10.3195f, 5.506f, 10.3149f, 5.5048f, 10.3138f, 5.5046f)
                curveTo(10.2009f, 5.472f, 10.0832f, 5.4095f, 9.9731f, 5.3198f)
                lineTo(9.49914f, 5.90101f)
                moveTo(12.4887f, 4.44762f)
                curveTo(12.3458f, 4.6389f, 12.1522f, 4.8346f, 11.9545f, 4.997f)
                lineTo(12.4887f, 4.44762f)
                close()
                moveTo(9.49914f, 5.90101f)
                curveTo(9.6779f, 6.0468f, 9.8848f, 6.1615f, 10.1067f, 6.2254f)
                lineTo(10.3161f, 1.33736f)
                curveTo(10.176f, 1.4467f, 10.1436f, 1.4784f, 9.9706f, 1.6513f)
                curveTo(9.9567f, 1.6651f, 9.9436f, 1.6783f, 9.9312f, 1.6907f)
                curveTo(9.7851f, 1.8367f, 9.7337f, 1.8882f, 9.6247f, 2.0283f)
                curveTo(8.9668f, 2.8761f, 8.6791f, 3.9228f, 8.8613f, 4.802f)
                curveTo(8.9338f, 5.1552f, 9.0842f, 5.4625f, 9.3007f, 5.7127f)
                curveTo(9.344f, 5.7626f, 9.4478f, 5.8589f, 9.4991f, 5.901f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF4552CB)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(17.3637f, 12.8583f)
                lineTo(17.3625f, 12.8565f)
                curveTo(17.3158f, 12.7858f, 17.3006f, 12.7654f, 17.257f, 12.7194f)
                curveTo(17.1276f, 12.584f, 16.9498f, 12.4718f, 16.6768f, 12.3775f)
                curveTo(16.4624f, 12.3042f, 16.2749f, 12.2673f, 16.0423f, 12.2611f)
                lineTo(16.0409f, 12.261f)
                lineTo(16.0365f, 12.2609f)
                curveTo(15.9371f, 12.258f, 15.8896f, 12.2567f, 15.8361f, 12.2599f)
                lineTo(15.7904f, 11.5113f)
                moveTo(17.3637f, 12.8583f)
                lineTo(15.102f, 15.1155f)
                curveTo(14.7003f, 15.1086f, 14.3352f, 14.9942f, 14.0855f, 14.8257f)
                curveTo(14.0443f, 14.7977f, 14.0312f, 14.7872f, 14.0217f, 14.779f)
                curveTo(14.0065f, 14.7661f, 13.9858f, 14.7469f, 13.9279f, 14.6905f)
                lineTo(13.9276f, 14.6902f)
                curveTo(13.9204f, 14.6831f, 13.9133f, 14.6763f, 13.9065f, 14.6696f)
                curveTo(13.8842f, 14.6478f, 13.8643f, 14.6285f, 13.8471f, 14.6115f)
                curveTo(13.8414f, 14.6058f, 13.8367f, 14.6011f, 13.833f, 14.5974f)
                curveTo(13.6997f, 14.43f, 13.631f, 14.2309f, 13.631f, 14.0235f)
                curveTo(13.631f, 13.6477f, 13.8512f, 13.1764f, 14.365f, 12.7931f)
                lineTo(14.3653f, 12.7928f)
                curveTo(14.7697f, 12.4908f, 15.3166f, 12.292f, 15.8366f, 12.2599f)
                lineTo(15.7904f, 11.5113f)
                moveTo(17.3637f, 12.8583f)
                curveTo(17.4019f, 12.9156f, 17.4304f, 12.9748f, 17.4646f, 13.0775f)
                lineTo(17.4646f, 13.0775f)
                lineTo(17.4655f, 13.0799f)
                curveTo(17.4981f, 13.1769f, 17.5103f, 13.249f, 17.5103f, 13.3738f)
                lineTo(17.3637f, 12.8583f)
                close()
                moveTo(15.7904f, 11.5113f)
                curveTo(15.1286f, 11.5522f, 14.441f, 11.8003f, 13.9165f, 12.1919f)
                lineTo(16.0624f, 11.5113f)
                curveTo(16.056f, 11.5111f, 16.0496f, 11.511f, 16.0433f, 11.5108f)
                curveTo(15.9576f, 11.5083f, 15.8785f, 11.506f, 15.7904f, 11.5113f)
                close()
                moveTo(16.9288f, 14.4638f)
                curveTo(16.5868f, 14.7634f, 16.1705f, 14.9709f, 15.6939f, 15.0675f)
                lineTo(16.9288f, 14.4638f)
                close()
                moveTo(15.6938f, 15.0675f)
                curveTo(15.5015f, 15.1064f, 15.331f, 15.1194f, 15.1022f, 15.1155f)
                lineTo(15.6938f, 15.0675f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF4552CB)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(4.56596f, 5.31709f)
                curveTo(4.566f, 5.3171f, 4.566f, 5.3171f, 4.566f, 5.3171f)
                curveTo(4.6162f, 5.3556f, 4.6383f, 5.3723f, 4.6579f, 5.3858f)
                curveTo(4.6719f, 5.3954f, 4.6826f, 5.4019f, 4.6986f, 5.41f)
                lineTo(4.69961f, 5.41048f)
                curveTo(5.0462f, 5.5866f, 5.581f, 5.5493f, 6.1311f, 5.038f)
                lineTo(4.56596f, 5.31709f)
                close()
                moveTo(4.56596f, 5.31709f)
                curveTo(4.5656f, 5.3168f, 4.5649f, 5.3163f, 4.5636f, 5.3153f)
                lineTo(4.55701f, 5.3099f)
                lineTo(4.5362f, 5.29249f)
                curveTo(4.5197f, 5.2784f, 4.5007f, 5.2618f, 4.4819f, 5.2448f)
                curveTo(4.4629f, 5.2275f, 4.4464f, 5.212f, 4.4341f, 5.2f)
                curveTo(4.4298f, 5.1957f, 4.4267f, 5.1926f, 4.4249f, 5.1907f)
                curveTo(4.248f, 4.9777f, 4.1238f, 4.6881f, 4.0919f, 4.319f)
                lineTo(4.56596f, 5.31709f)
                close()
                moveTo(5.90248f, 1.76262f)
                lineTo(5.90046f, 1.76272f)
                curveTo(5.7632f, 1.7688f, 5.6215f, 1.797f, 5.4789f, 1.8544f)
                curveTo(5.3638f, 1.9015f, 5.2077f, 1.9878f, 5.0908f, 2.0746f)
                curveTo(5.0381f, 2.1141f, 5.0197f, 2.1296f, 5.0014f, 2.1462f)
                curveTo(4.9748f, 2.1705f, 4.9426f, 2.2024f, 4.8595f, 2.2858f)
                lineTo(4.85879f, 2.28645f)
                curveTo(4.7806f, 2.3647f, 4.7492f, 2.3981f, 4.7276f, 2.423f)
                curveTo(4.707f, 2.4468f, 4.6885f, 2.4705f, 4.636f, 2.5407f)
                lineTo(4.63544f, 2.54146f)
                curveTo(4.2406f, 3.0675f, 4.0423f, 3.7429f, 4.0919f, 4.3189f)
                lineTo(5.90248f, 1.76262f)
                close()
                moveTo(5.90248f, 1.76262f)
                curveTo(6.1078f, 1.753f, 6.2873f, 1.8042f, 6.4469f, 1.9138f)
                lineTo(5.90248f, 1.76262f)
                close()
                moveTo(6.67167f, 2.13554f)
                curveTo(6.9332f, 2.483f, 7.0567f, 3.117f, 6.8614f, 3.8146f)
                lineTo(6.44695f, 1.91386f)
                curveTo(6.5161f, 1.9614f, 6.5989f, 2.0398f, 6.6717f, 2.1355f)
                close()
                moveTo(6.86131f, 3.81486f)
                curveTo(6.7261f, 4.2968f, 6.4629f, 4.7294f, 6.1312f, 5.0379f)
                lineTo(6.86131f, 3.81486f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF4552CB)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(16.5691f, 6.01031f)
                lineTo(16.5691f, 6.0103f)
                curveTo(16.5693f, 6.0103f, 16.5682f, 6.0102f, 16.5656f, 6.0101f)
                lineTo(16.5553f, 6.00956f)
                curveTo(16.5464f, 6.0092f, 16.5352f, 6.0088f, 16.5217f, 6.0085f)
                curveTo(16.4945f, 6.0078f, 16.4623f, 6.0075f, 16.4283f, 6.0076f)
                curveTo(16.3569f, 6.0077f, 16.2948f, 6.0094f, 16.2656f, 6.0112f)
                lineTo(16.5691f, 6.01031f)
                close()
                moveTo(16.5691f, 6.01031f)
                lineTo(16.5719f, 6.01052f)
                moveTo(16.5691f, 6.01031f)
                lineTo(16.5719f, 6.01052f)
                moveTo(16.5719f, 6.01052f)
                curveTo(16.9527f, 6.039f, 17.2332f, 6.1565f, 17.4413f, 6.3257f)
                lineTo(16.5719f, 6.01052f)
                close()
                moveTo(13.481f, 8.21094f)
                lineTo(13.4808f, 8.21193f)
                curveTo(13.3986f, 8.6319f, 13.4956f, 8.9574f, 13.7037f, 9.1932f)
                curveTo(13.8359f, 9.3424f, 14.0662f, 9.4861f, 14.3591f, 9.5589f)
                lineTo(14.3594f, 9.55897f)
                curveTo(15.1126f, 9.7464f, 16.1472f, 9.474f, 16.955f, 8.7536f)
                lineTo(16.9565f, 8.7523f)
                curveTo(16.9797f, 8.7317f, 17.0414f, 8.673f, 17.1112f, 8.6034f)
                curveTo(17.1442f, 8.5706f, 17.1752f, 8.5391f, 17.2001f, 8.5132f)
                curveTo(17.2197f, 8.4927f, 17.2301f, 8.4813f, 17.2337f, 8.4774f)
                curveTo(17.2354f, 8.4755f, 17.2356f, 8.4753f, 17.2346f, 8.4766f)
                lineTo(17.2364f, 8.47444f)
                curveTo(17.5402f, 8.1134f, 17.7096f, 7.759f, 17.7777f, 7.4336f)
                curveTo(17.8615f, 7.0269f, 17.7862f, 6.7278f, 17.6048f, 6.4866f)
                curveTo(17.6029f, 6.4844f, 17.5984f, 6.4793f, 17.5908f, 6.471f)
                curveTo(17.5762f, 6.4553f, 17.557f, 6.4354f, 17.5354f, 6.4139f)
                curveTo(17.5139f, 6.3925f, 17.4924f, 6.3719f, 17.4737f, 6.3546f)
                curveTo(17.4645f, 6.3461f, 17.4566f, 6.339f, 17.4505f, 6.3336f)
                lineTo(13.481f, 8.21094f)
                close()
                moveTo(13.481f, 8.21094f)
                curveTo(13.5453f, 7.8803f, 13.7107f, 7.5287f, 14.0109f, 7.1668f)
                curveTo(14.0109f, 7.1668f, 14.0109f, 7.1668f, 14.0109f, 7.1668f)
                curveTo(14.0109f, 7.1668f, 14.011f, 7.1667f, 14.011f, 7.1666f)
                curveTo(14.0127f, 7.1648f, 14.0252f, 7.1506f, 14.0532f, 7.1214f)
                curveTo(14.0804f, 7.093f, 14.1138f, 7.0592f, 14.1494f, 7.0238f)
                curveTo(14.223f, 6.9507f, 14.2912f, 6.8858f, 14.3215f, 6.8587f)
                curveTo(14.8918f, 6.3518f, 15.6008f, 6.0522f, 16.2653f, 6.0112f)
                lineTo(13.481f, 8.21094f)
                close()
                moveTo(17.6007f, 6.48114f)
                lineTo(17.6007f, 6.4812f)
                lineTo(17.6007f, 6.48114f)
                close()
            }
        }.build()
        return _vector!!
    }