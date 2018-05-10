package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.ListMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Onboarding {
    public static final Adapter<Onboarding, Builder> ADAPTER = new OnboardingAdapter();
    public final String action_source;
    public final Long captcha_num_screens;
    public final String category_name;
    public final Long category_position;
    public final Long end_timestamp;
    public final String id;
    public final Boolean is_similar_subreddit;
    public final String landing_page;
    public final Long number_subreddits;
    public final Long number_subreddits_selected;
    public final Boolean passed_captcha;
    public final Long personalized_subreddits;
    public final Boolean pre_selected;
    public final String process_notes;
    public final Boolean recommended_user_name;
    public final String semantic_version;
    public final List<String> similar_subreddits;
    public final Long start_timestamp;
    public final Boolean subreddit_is_selected;
    public final String subreddit_name;
    public final Long subreddit_position;
    public final Long subreddits_already_selected;
    public final List<String> subreddits_selected;
    public final Boolean successful;
    public final String user_name;
    public final Boolean valid_email_submitted;

    public static final class Builder implements StructBuilder<Onboarding> {
        private String action_source;
        private Long captcha_num_screens;
        private String category_name;
        private Long category_position;
        private Long end_timestamp;
        private String id;
        private Boolean is_similar_subreddit;
        private String landing_page;
        private Long number_subreddits;
        private Long number_subreddits_selected;
        private Boolean passed_captcha;
        private Long personalized_subreddits;
        private Boolean pre_selected;
        private String process_notes;
        private Boolean recommended_user_name;
        private String semantic_version;
        private List<String> similar_subreddits;
        private Long start_timestamp;
        private Boolean subreddit_is_selected;
        private String subreddit_name;
        private Long subreddit_position;
        private Long subreddits_already_selected;
        private List<String> subreddits_selected;
        private Boolean successful;
        private String user_name;
        private Boolean valid_email_submitted;

        public Builder(Onboarding onboarding) {
            this.id = onboarding.id;
            this.action_source = onboarding.action_source;
            this.process_notes = onboarding.process_notes;
            this.number_subreddits_selected = onboarding.number_subreddits_selected;
            this.subreddits_selected = onboarding.subreddits_selected;
            this.user_name = onboarding.user_name;
            this.recommended_user_name = onboarding.recommended_user_name;
            this.start_timestamp = onboarding.start_timestamp;
            this.end_timestamp = onboarding.end_timestamp;
            this.category_position = onboarding.category_position;
            this.category_name = onboarding.category_name;
            this.subreddit_name = onboarding.subreddit_name;
            this.subreddit_position = onboarding.subreddit_position;
            this.subreddit_is_selected = onboarding.subreddit_is_selected;
            this.subreddits_already_selected = onboarding.subreddits_already_selected;
            this.successful = onboarding.successful;
            this.semantic_version = onboarding.semantic_version;
            this.landing_page = onboarding.landing_page;
            this.valid_email_submitted = onboarding.valid_email_submitted;
            this.pre_selected = onboarding.pre_selected;
            this.passed_captcha = onboarding.passed_captcha;
            this.captcha_num_screens = onboarding.captcha_num_screens;
            this.personalized_subreddits = onboarding.personalized_subreddits;
            this.similar_subreddits = onboarding.similar_subreddits;
            this.number_subreddits = onboarding.number_subreddits;
            this.is_similar_subreddit = onboarding.is_similar_subreddit;
        }

        public final Builder id(String str) {
            this.id = str;
            return this;
        }

        public final Builder action_source(String str) {
            this.action_source = str;
            return this;
        }

        public final Builder process_notes(String str) {
            this.process_notes = str;
            return this;
        }

        public final Builder number_subreddits_selected(Long l) {
            this.number_subreddits_selected = l;
            return this;
        }

        public final Builder subreddits_selected(List<String> list) {
            this.subreddits_selected = list;
            return this;
        }

        public final Builder user_name(String str) {
            this.user_name = str;
            return this;
        }

        public final Builder recommended_user_name(Boolean bool) {
            this.recommended_user_name = bool;
            return this;
        }

        public final Builder start_timestamp(Long l) {
            this.start_timestamp = l;
            return this;
        }

        public final Builder end_timestamp(Long l) {
            this.end_timestamp = l;
            return this;
        }

        public final Builder category_position(Long l) {
            this.category_position = l;
            return this;
        }

        public final Builder category_name(String str) {
            this.category_name = str;
            return this;
        }

        public final Builder subreddit_name(String str) {
            this.subreddit_name = str;
            return this;
        }

        public final Builder subreddit_position(Long l) {
            this.subreddit_position = l;
            return this;
        }

        public final Builder subreddit_is_selected(Boolean bool) {
            this.subreddit_is_selected = bool;
            return this;
        }

        public final Builder subreddits_already_selected(Long l) {
            this.subreddits_already_selected = l;
            return this;
        }

        public final Builder successful(Boolean bool) {
            this.successful = bool;
            return this;
        }

        public final Builder semantic_version(String str) {
            this.semantic_version = str;
            return this;
        }

        public final Builder landing_page(String str) {
            this.landing_page = str;
            return this;
        }

        public final Builder valid_email_submitted(Boolean bool) {
            this.valid_email_submitted = bool;
            return this;
        }

        public final Builder pre_selected(Boolean bool) {
            this.pre_selected = bool;
            return this;
        }

        public final Builder passed_captcha(Boolean bool) {
            this.passed_captcha = bool;
            return this;
        }

        public final Builder captcha_num_screens(Long l) {
            this.captcha_num_screens = l;
            return this;
        }

        public final Builder personalized_subreddits(Long l) {
            this.personalized_subreddits = l;
            return this;
        }

        public final Builder similar_subreddits(List<String> list) {
            this.similar_subreddits = list;
            return this;
        }

        public final Builder number_subreddits(Long l) {
            this.number_subreddits = l;
            return this;
        }

        public final Builder is_similar_subreddit(Boolean bool) {
            this.is_similar_subreddit = bool;
            return this;
        }

        public final Onboarding build() {
            return new Onboarding();
        }

        public final void reset() {
            this.id = null;
            this.action_source = null;
            this.process_notes = null;
            this.number_subreddits_selected = null;
            this.subreddits_selected = null;
            this.user_name = null;
            this.recommended_user_name = null;
            this.start_timestamp = null;
            this.end_timestamp = null;
            this.category_position = null;
            this.category_name = null;
            this.subreddit_name = null;
            this.subreddit_position = null;
            this.subreddit_is_selected = null;
            this.subreddits_already_selected = null;
            this.successful = null;
            this.semantic_version = null;
            this.landing_page = null;
            this.valid_email_submitted = null;
            this.pre_selected = null;
            this.passed_captcha = null;
            this.captcha_num_screens = null;
            this.personalized_subreddits = null;
            this.similar_subreddits = null;
            this.number_subreddits = null;
            this.is_similar_subreddit = null;
        }
    }

    private static final class OnboardingAdapter implements Adapter<Onboarding, Builder> {
        private OnboardingAdapter() {
        }

        public final void write(Protocol protocol, Onboarding onboarding) throws IOException {
            if (onboarding.id != null) {
                protocol.mo2638a(1, (byte) 11);
                protocol.mo2640a(onboarding.id);
            }
            if (onboarding.action_source != null) {
                protocol.mo2638a(6, (byte) 11);
                protocol.mo2640a(onboarding.action_source);
            }
            if (onboarding.process_notes != null) {
                protocol.mo2638a(7, (byte) 11);
                protocol.mo2640a(onboarding.process_notes);
            }
            if (onboarding.number_subreddits_selected != null) {
                protocol.mo2638a(8, (byte) 10);
                protocol.mo2639a(onboarding.number_subreddits_selected.longValue());
            }
            if (onboarding.subreddits_selected != null) {
                protocol.mo2638a(9, (byte) 15);
                protocol.mo2635a((byte) 11, onboarding.subreddits_selected.size());
                for (String a : onboarding.subreddits_selected) {
                    protocol.mo2640a(a);
                }
            }
            if (onboarding.user_name != null) {
                protocol.mo2638a(10, (byte) 11);
                protocol.mo2640a(onboarding.user_name);
            }
            if (onboarding.recommended_user_name != null) {
                protocol.mo2638a(11, (byte) 2);
                protocol.mo2641a(onboarding.recommended_user_name.booleanValue());
            }
            if (onboarding.start_timestamp != null) {
                protocol.mo2638a(12, (byte) 10);
                protocol.mo2639a(onboarding.start_timestamp.longValue());
            }
            if (onboarding.end_timestamp != null) {
                protocol.mo2638a(13, (byte) 10);
                protocol.mo2639a(onboarding.end_timestamp.longValue());
            }
            if (onboarding.category_position != null) {
                protocol.mo2638a(14, (byte) 10);
                protocol.mo2639a(onboarding.category_position.longValue());
            }
            if (onboarding.category_name != null) {
                protocol.mo2638a(15, (byte) 11);
                protocol.mo2640a(onboarding.category_name);
            }
            if (onboarding.subreddit_name != null) {
                protocol.mo2638a(16, (byte) 11);
                protocol.mo2640a(onboarding.subreddit_name);
            }
            if (onboarding.subreddit_position != null) {
                protocol.mo2638a(17, (byte) 10);
                protocol.mo2639a(onboarding.subreddit_position.longValue());
            }
            if (onboarding.subreddit_is_selected != null) {
                protocol.mo2638a(18, (byte) 2);
                protocol.mo2641a(onboarding.subreddit_is_selected.booleanValue());
            }
            if (onboarding.subreddits_already_selected != null) {
                protocol.mo2638a(19, (byte) 10);
                protocol.mo2639a(onboarding.subreddits_already_selected.longValue());
            }
            if (onboarding.successful != null) {
                protocol.mo2638a(20, (byte) 2);
                protocol.mo2641a(onboarding.successful.booleanValue());
            }
            if (onboarding.semantic_version != null) {
                protocol.mo2638a(21, (byte) 11);
                protocol.mo2640a(onboarding.semantic_version);
            }
            if (onboarding.landing_page != null) {
                protocol.mo2638a(22, (byte) 11);
                protocol.mo2640a(onboarding.landing_page);
            }
            if (onboarding.valid_email_submitted != null) {
                protocol.mo2638a(23, (byte) 2);
                protocol.mo2641a(onboarding.valid_email_submitted.booleanValue());
            }
            if (onboarding.pre_selected != null) {
                protocol.mo2638a(24, (byte) 2);
                protocol.mo2641a(onboarding.pre_selected.booleanValue());
            }
            if (onboarding.passed_captcha != null) {
                protocol.mo2638a(25, (byte) 2);
                protocol.mo2641a(onboarding.passed_captcha.booleanValue());
            }
            if (onboarding.captcha_num_screens != null) {
                protocol.mo2638a(26, (byte) 10);
                protocol.mo2639a(onboarding.captcha_num_screens.longValue());
            }
            if (onboarding.personalized_subreddits != null) {
                protocol.mo2638a(27, (byte) 10);
                protocol.mo2639a(onboarding.personalized_subreddits.longValue());
            }
            if (onboarding.similar_subreddits != null) {
                protocol.mo2638a(28, (byte) 15);
                protocol.mo2635a((byte) 11, onboarding.similar_subreddits.size());
                for (String a2 : onboarding.similar_subreddits) {
                    protocol.mo2640a(a2);
                }
            }
            if (onboarding.number_subreddits != null) {
                protocol.mo2638a(29, (byte) 10);
                protocol.mo2639a(onboarding.number_subreddits.longValue());
            }
            if (onboarding.is_similar_subreddit != null) {
                protocol.mo2638a(30, (byte) 2);
                protocol.mo2641a(onboarding.is_similar_subreddit.booleanValue());
            }
            protocol.mo2634a();
        }

        public final Onboarding read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b == (byte) 0) {
                    return builder.build();
                }
                short s = b.f10037c;
                if (s != (short) 1) {
                    int i = 0;
                    ListMetadata d;
                    List arrayList;
                    switch (s) {
                        case (short) 6:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.action_source(protocol.mo2652l());
                            break;
                        case (short) 7:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.process_notes(protocol.mo2652l());
                            break;
                        case (short) 8:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.number_subreddits_selected(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 9:
                            if (b.f10036b != (byte) 15) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            d = protocol.mo2644d();
                            arrayList = new ArrayList(d.f10039b);
                            while (i < d.f10039b) {
                                arrayList.add(protocol.mo2652l());
                                i++;
                            }
                            builder.subreddits_selected(arrayList);
                            break;
                        case (short) 10:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.user_name(protocol.mo2652l());
                            break;
                        case (short) 11:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.recommended_user_name(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 12:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.start_timestamp(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 13:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.end_timestamp(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 14:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.category_position(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 15:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.category_name(protocol.mo2652l());
                            break;
                        case (short) 16:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.subreddit_name(protocol.mo2652l());
                            break;
                        case (short) 17:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.subreddit_position(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 18:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.subreddit_is_selected(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 19:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.subreddits_already_selected(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 20:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.successful(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 21:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.semantic_version(protocol.mo2652l());
                            break;
                        case (short) 22:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.landing_page(protocol.mo2652l());
                            break;
                        case (short) 23:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.valid_email_submitted(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 24:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.pre_selected(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 25:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.passed_captcha(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 26:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.captcha_num_screens(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 27:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.personalized_subreddits(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 28:
                            if (b.f10036b != (byte) 15) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            d = protocol.mo2644d();
                            arrayList = new ArrayList(d.f10039b);
                            while (i < d.f10039b) {
                                arrayList.add(protocol.mo2652l());
                                i++;
                            }
                            builder.similar_subreddits(arrayList);
                            break;
                        case (short) 29:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.number_subreddits(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 30:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.is_similar_subreddit(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                } else if (b.f10036b == (byte) 11) {
                    builder.id(protocol.mo2652l());
                } else {
                    ProtocolUtil.m8514a(protocol, b.f10036b);
                }
            }
        }

        public final Onboarding read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Onboarding(Builder builder) {
        this.id = builder.id;
        this.action_source = builder.action_source;
        this.process_notes = builder.process_notes;
        this.number_subreddits_selected = builder.number_subreddits_selected;
        List list = null;
        this.subreddits_selected = builder.subreddits_selected == null ? null : Collections.unmodifiableList(builder.subreddits_selected);
        this.user_name = builder.user_name;
        this.recommended_user_name = builder.recommended_user_name;
        this.start_timestamp = builder.start_timestamp;
        this.end_timestamp = builder.end_timestamp;
        this.category_position = builder.category_position;
        this.category_name = builder.category_name;
        this.subreddit_name = builder.subreddit_name;
        this.subreddit_position = builder.subreddit_position;
        this.subreddit_is_selected = builder.subreddit_is_selected;
        this.subreddits_already_selected = builder.subreddits_already_selected;
        this.successful = builder.successful;
        this.semantic_version = builder.semantic_version;
        this.landing_page = builder.landing_page;
        this.valid_email_submitted = builder.valid_email_submitted;
        this.pre_selected = builder.pre_selected;
        this.passed_captcha = builder.passed_captcha;
        this.captcha_num_screens = builder.captcha_num_screens;
        this.personalized_subreddits = builder.personalized_subreddits;
        if (builder.similar_subreddits != null) {
            list = Collections.unmodifiableList(builder.similar_subreddits);
        }
        this.similar_subreddits = list;
        this.number_subreddits = builder.number_subreddits;
        this.is_similar_subreddit = builder.is_similar_subreddit;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Onboarding)) {
            return false;
        }
        Onboarding onboarding = (Onboarding) obj;
        if ((this.id == onboarding.id || (this.id != null && this.id.equals(onboarding.id))) && ((this.action_source == onboarding.action_source || (this.action_source != null && this.action_source.equals(onboarding.action_source))) && ((this.process_notes == onboarding.process_notes || (this.process_notes != null && this.process_notes.equals(onboarding.process_notes))) && ((this.number_subreddits_selected == onboarding.number_subreddits_selected || (this.number_subreddits_selected != null && this.number_subreddits_selected.equals(onboarding.number_subreddits_selected))) && ((this.subreddits_selected == onboarding.subreddits_selected || (this.subreddits_selected != null && this.subreddits_selected.equals(onboarding.subreddits_selected))) && ((this.user_name == onboarding.user_name || (this.user_name != null && this.user_name.equals(onboarding.user_name))) && ((this.recommended_user_name == onboarding.recommended_user_name || (this.recommended_user_name != null && this.recommended_user_name.equals(onboarding.recommended_user_name))) && ((this.start_timestamp == onboarding.start_timestamp || (this.start_timestamp != null && this.start_timestamp.equals(onboarding.start_timestamp))) && ((this.end_timestamp == onboarding.end_timestamp || (this.end_timestamp != null && this.end_timestamp.equals(onboarding.end_timestamp))) && ((this.category_position == onboarding.category_position || (this.category_position != null && this.category_position.equals(onboarding.category_position))) && ((this.category_name == onboarding.category_name || (this.category_name != null && this.category_name.equals(onboarding.category_name))) && ((this.subreddit_name == onboarding.subreddit_name || (this.subreddit_name != null && this.subreddit_name.equals(onboarding.subreddit_name))) && ((this.subreddit_position == onboarding.subreddit_position || (this.subreddit_position != null && this.subreddit_position.equals(onboarding.subreddit_position))) && ((this.subreddit_is_selected == onboarding.subreddit_is_selected || (this.subreddit_is_selected != null && this.subreddit_is_selected.equals(onboarding.subreddit_is_selected))) && ((this.subreddits_already_selected == onboarding.subreddits_already_selected || (this.subreddits_already_selected != null && this.subreddits_already_selected.equals(onboarding.subreddits_already_selected))) && ((this.successful == onboarding.successful || (this.successful != null && this.successful.equals(onboarding.successful))) && ((this.semantic_version == onboarding.semantic_version || (this.semantic_version != null && this.semantic_version.equals(onboarding.semantic_version))) && ((this.landing_page == onboarding.landing_page || (this.landing_page != null && this.landing_page.equals(onboarding.landing_page))) && ((this.valid_email_submitted == onboarding.valid_email_submitted || (this.valid_email_submitted != null && this.valid_email_submitted.equals(onboarding.valid_email_submitted))) && ((this.pre_selected == onboarding.pre_selected || (this.pre_selected != null && this.pre_selected.equals(onboarding.pre_selected))) && ((this.passed_captcha == onboarding.passed_captcha || (this.passed_captcha != null && this.passed_captcha.equals(onboarding.passed_captcha))) && ((this.captcha_num_screens == onboarding.captcha_num_screens || (this.captcha_num_screens != null && this.captcha_num_screens.equals(onboarding.captcha_num_screens))) && ((this.personalized_subreddits == onboarding.personalized_subreddits || (this.personalized_subreddits != null && this.personalized_subreddits.equals(onboarding.personalized_subreddits))) && ((this.similar_subreddits == onboarding.similar_subreddits || (this.similar_subreddits != null && this.similar_subreddits.equals(onboarding.similar_subreddits))) && (this.number_subreddits == onboarding.number_subreddits || (this.number_subreddits != null && this.number_subreddits.equals(onboarding.number_subreddits))))))))))))))))))))))))))) {
            if (this.is_similar_subreddit != onboarding.is_similar_subreddit) {
                if (!(this.is_similar_subreddit == null || this.is_similar_subreddit.equals(onboarding.is_similar_subreddit) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) ^ 16777619) * -2128831035) ^ (this.action_source == null ? 0 : this.action_source.hashCode())) * -2128831035) ^ (this.process_notes == null ? 0 : this.process_notes.hashCode())) * -2128831035) ^ (this.number_subreddits_selected == null ? 0 : this.number_subreddits_selected.hashCode())) * -2128831035) ^ (this.subreddits_selected == null ? 0 : this.subreddits_selected.hashCode())) * -2128831035) ^ (this.user_name == null ? 0 : this.user_name.hashCode())) * -2128831035) ^ (this.recommended_user_name == null ? 0 : this.recommended_user_name.hashCode())) * -2128831035) ^ (this.start_timestamp == null ? 0 : this.start_timestamp.hashCode())) * -2128831035) ^ (this.end_timestamp == null ? 0 : this.end_timestamp.hashCode())) * -2128831035) ^ (this.category_position == null ? 0 : this.category_position.hashCode())) * -2128831035) ^ (this.category_name == null ? 0 : this.category_name.hashCode())) * -2128831035) ^ (this.subreddit_name == null ? 0 : this.subreddit_name.hashCode())) * -2128831035) ^ (this.subreddit_position == null ? 0 : this.subreddit_position.hashCode())) * -2128831035) ^ (this.subreddit_is_selected == null ? 0 : this.subreddit_is_selected.hashCode())) * -2128831035) ^ (this.subreddits_already_selected == null ? 0 : this.subreddits_already_selected.hashCode())) * -2128831035) ^ (this.successful == null ? 0 : this.successful.hashCode())) * -2128831035) ^ (this.semantic_version == null ? 0 : this.semantic_version.hashCode())) * -2128831035) ^ (this.landing_page == null ? 0 : this.landing_page.hashCode())) * -2128831035) ^ (this.valid_email_submitted == null ? 0 : this.valid_email_submitted.hashCode())) * -2128831035) ^ (this.pre_selected == null ? 0 : this.pre_selected.hashCode())) * -2128831035) ^ (this.passed_captcha == null ? 0 : this.passed_captcha.hashCode())) * -2128831035) ^ (this.captcha_num_screens == null ? 0 : this.captcha_num_screens.hashCode())) * -2128831035) ^ (this.personalized_subreddits == null ? 0 : this.personalized_subreddits.hashCode())) * -2128831035) ^ (this.similar_subreddits == null ? 0 : this.similar_subreddits.hashCode())) * -2128831035) ^ (this.number_subreddits == null ? 0 : this.number_subreddits.hashCode())) * -2128831035;
        if (this.is_similar_subreddit != null) {
            i = this.is_similar_subreddit.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Onboarding{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", action_source=");
        stringBuilder.append(this.action_source);
        stringBuilder.append(", process_notes=");
        stringBuilder.append(this.process_notes);
        stringBuilder.append(", number_subreddits_selected=");
        stringBuilder.append(this.number_subreddits_selected);
        stringBuilder.append(", subreddits_selected=");
        stringBuilder.append(this.subreddits_selected);
        stringBuilder.append(", user_name=");
        stringBuilder.append(this.user_name);
        stringBuilder.append(", recommended_user_name=");
        stringBuilder.append(this.recommended_user_name);
        stringBuilder.append(", start_timestamp=");
        stringBuilder.append(this.start_timestamp);
        stringBuilder.append(", end_timestamp=");
        stringBuilder.append(this.end_timestamp);
        stringBuilder.append(", category_position=");
        stringBuilder.append(this.category_position);
        stringBuilder.append(", category_name=");
        stringBuilder.append(this.category_name);
        stringBuilder.append(", subreddit_name=");
        stringBuilder.append(this.subreddit_name);
        stringBuilder.append(", subreddit_position=");
        stringBuilder.append(this.subreddit_position);
        stringBuilder.append(", subreddit_is_selected=");
        stringBuilder.append(this.subreddit_is_selected);
        stringBuilder.append(", subreddits_already_selected=");
        stringBuilder.append(this.subreddits_already_selected);
        stringBuilder.append(", successful=");
        stringBuilder.append(this.successful);
        stringBuilder.append(", semantic_version=");
        stringBuilder.append(this.semantic_version);
        stringBuilder.append(", landing_page=");
        stringBuilder.append(this.landing_page);
        stringBuilder.append(", valid_email_submitted=");
        stringBuilder.append(this.valid_email_submitted);
        stringBuilder.append(", pre_selected=");
        stringBuilder.append(this.pre_selected);
        stringBuilder.append(", passed_captcha=");
        stringBuilder.append(this.passed_captcha);
        stringBuilder.append(", captcha_num_screens=");
        stringBuilder.append(this.captcha_num_screens);
        stringBuilder.append(", personalized_subreddits=");
        stringBuilder.append(this.personalized_subreddits);
        stringBuilder.append(", similar_subreddits=");
        stringBuilder.append(this.similar_subreddits);
        stringBuilder.append(", number_subreddits=");
        stringBuilder.append(this.number_subreddits);
        stringBuilder.append(", is_similar_subreddit=");
        stringBuilder.append(this.is_similar_subreddit);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
