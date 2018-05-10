package io.branch.referral;

public class BranchError {
    String f24492a = "";
    int f24493b = -113;

    public final String m26100a() {
        return this.f24492a;
    }

    public BranchError(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        if (i == -113) {
            this.f24493b = -113;
            str = " Branch API Error: poor network connectivity. Please try again later.";
        } else if (i == -114) {
            this.f24493b = -114;
            str = " Branch API Error: Please enter your branch_key in your project's manifest file first.";
        } else if (i == -104) {
            this.f24493b = -104;
            str = " Did you forget to call init? Make sure you init the session before making Branch calls.";
        } else if (i == -101) {
            this.f24493b = -101;
            str = " Unable to initialize Branch. Check network connectivity or that your branch key is valid.";
        } else if (i == -102) {
            this.f24493b = -102;
            str = " Please add 'android.permission.INTERNET' in your applications manifest file.";
        } else if (i == -105) {
            this.f24493b = -105;
            str = " Unable to create a URL with that alias. If you want to reuse the alias, make sure to submit the same properties for all arguments and that the user is the same owner.";
        } else if (i == -106) {
            this.f24493b = -106;
            str = " That Branch referral code is already in use.";
        } else if (i == -107) {
            this.f24493b = -107;
            str = " Unable to redeem rewards. Please make sure you have credits available to redeem.";
        } else if (i == -108) {
            this.f24493b = -108;
            str = "BranchApp class can be used only with API level 14 or above. Please make sure your minimum API level supported is 14. If you wish to use API level below 14 consider calling getInstance(Context) instead.";
        } else if (i == -109) {
            this.f24493b = -109;
            str = "Branch instance is not created. Make  sure your Application class is an instance of BranchLikedApp.";
        } else if (i == -110) {
            this.f24493b = -110;
            str = " Unable create share options. Couldn't find applications on device to share the link.";
        } else if (i == -111) {
            this.f24493b = -111;
            str = " Request to Branch server timed out. Please check your internet connectivity";
        } else {
            if (i < 500) {
                if (i != -112) {
                    if (i != 409) {
                        if (i != -115) {
                            if (i < 400) {
                                if (i != -116) {
                                    this.f24493b = -113;
                                    str = " Check network connectivity and that you properly initialized.";
                                }
                            }
                            this.f24493b = -116;
                            str = " The request was invalid.";
                        }
                    }
                    this.f24493b = -115;
                    str = " A resource with this identifier already exists.";
                }
            }
            this.f24493b = -112;
            str = " Unable to reach the Branch servers, please try again shortly.";
        }
        stringBuilder.append(str);
        this.f24492a = stringBuilder.toString();
    }

    public String toString() {
        return this.f24492a;
    }
}
