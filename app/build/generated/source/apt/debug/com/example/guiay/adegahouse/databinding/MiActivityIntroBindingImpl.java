package com.example.guiay.adegahouse.databinding;
import com.example.guiay.adegahouse.R;
import com.example.guiay.adegahouse.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class MiActivityIntroBindingImpl extends MiActivityIntroBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.mi_pager, 1);
        sViewsWithIds.put(R.id.mi_button_back, 2);
        sViewsWithIds.put(R.id.mi_button_next, 3);
        sViewsWithIds.put(R.id.mi_pager_indicator, 4);
        sViewsWithIds.put(R.id.mi_button_cta, 5);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public MiActivityIntroBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private MiActivityIntroBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageButton) bindings[2]
            , (android.widget.TextSwitcher) bindings[5]
            , (android.widget.ImageButton) bindings[3]
            , (android.support.constraint.ConstraintLayout) bindings[0]
            , (com.heinrichreimersoftware.materialintro.view.FadeableViewPager) bindings[1]
            , (com.heinrichreimersoftware.materialintro.view.InkPageIndicator) bindings[4]
            );
        this.miFrame.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}