package com.reddit.frontpage.video.mpdparser.injection.component;

public final class DaggerLibraryComponent implements LibraryComponent {

    public static final class Builder {
        private Builder() {
        }

        public static LibraryComponent m24128a() {
            return new DaggerLibraryComponent();
        }
    }

    private DaggerLibraryComponent() {
    }

    public static Builder m30474a() {
        return new Builder();
    }
}
