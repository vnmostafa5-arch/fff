# TestMod - مود حساب وقت العالم

مود Fabric لـ Minecraft Java Edition **26.1.2**  
يحسب الساعات والدقائق منذ بدء العالم ويبث رسالة للاعبين كل ساعة.

## كيف يشتغل؟

- كل **دقيقة حقيقية** يسجل في الـ console: كم ساعة ودقيقة مضت من عمر العالم
- كل **ساعة حقيقية** يبعت رسالة لكل اللاعبين على السيرفر

## متطلبات التشغيل

| المتطلب | الإصدار |
|---------|---------|
| Minecraft Java | 26.1.2 |
| Fabric Loader | 0.18.4+ |
| Fabric API | 0.149.1+26.1.2 |
| Java | 25+ |

## طريقة البناء محلياً

```bash
./gradlew build
```

الـ JAR هيتولد في مجلد `build/libs/`

## GitHub Actions

المشروع معاه workflow جاهز في `.github/workflows/build.yml`:

- **كل push على main:** يبني المود ويرفع الـ JAR كـ artifact
- **لما تعمل tag `v*`:** يبني ويعمل GitHub Release تلقائياً

### عشان تعمل Release:

```bash
git tag v1.0.0
git push origin v1.0.0
```

وهيتعمل Release تلقائياً على GitHub! 🎉
