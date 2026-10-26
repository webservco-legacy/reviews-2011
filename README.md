# Reviews 2011

A small Android app of 2014: a set of record reviews (from 2011) read offline, one HTML page per review, shown in a
full-screen WebView over the app's local pages, with an index and links between the pages. The app remembers the last
page read and opens it again. A historical archive, kept read-only: built for the Android SDK of its time (target API
20, an Eclipse project with the support library), not maintained.

## History

| Date | Commit | |
|---|---|---|
| 2014-10-14 | 81ec0c5 | the app, from my Eclipse copy |

## What is in it

- `src/co/webserv/android/reviews2011/MainActivity.java`: the activity and the WebView;
- `res/`: the layout, the menu, the strings and styles, the launcher icons;
- `assets/`: the pages. In this public copy only a made-up sample of two pages and their index: the 727 pages of the
  app (726 reviews and the index) are someone else's texts, so they are not included, in the history either.

## How it was built

From my Eclipse workspace copy, turned into git in 2026 (2 commits), the dates kept. The last commit before
this README sets LF line endings and indents with spaces.

## Third-party code

The Android Support Library v4 (`libs/android-support-v4.jar`, Apache License 2.0).

## Licence

MIT (see `LICENSE`), added in 2026: the project named no licence.

See also my other Android archives in [android-2010-2014](https://github.com/webservco-legacy/android-2010-2014).
