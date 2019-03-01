package com.example.guiay.adegahouse;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.example.guiay.adegahouse.databinding.MiActivityIntroBindingImpl;
import com.example.guiay.adegahouse.databinding.MiFragmentSimpleSlideBindingImpl;
import com.example.guiay.adegahouse.databinding.MiFragmentSimpleSlideBindingLandImpl;
import com.example.guiay.adegahouse.databinding.MiFragmentSimpleSlideScrollableBindingImpl;
import com.example.guiay.adegahouse.databinding.MiFragmentSimpleSlideScrollableBindingLandImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_MIACTIVITYINTRO = 1;

  private static final int LAYOUT_MIFRAGMENTSIMPLESLIDE = 2;

  private static final int LAYOUT_MIFRAGMENTSIMPLESLIDESCROLLABLE = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.guiay.adegahouse.R.layout.mi_activity_intro, LAYOUT_MIACTIVITYINTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.guiay.adegahouse.R.layout.mi_fragment_simple_slide, LAYOUT_MIFRAGMENTSIMPLESLIDE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.guiay.adegahouse.R.layout.mi_fragment_simple_slide_scrollable, LAYOUT_MIFRAGMENTSIMPLESLIDESCROLLABLE);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_MIACTIVITYINTRO: {
          if ("layout/mi_activity_intro_0".equals(tag)) {
            return new MiActivityIntroBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for mi_activity_intro is invalid. Received: " + tag);
        }
        case  LAYOUT_MIFRAGMENTSIMPLESLIDE: {
          if ("layout-land/mi_fragment_simple_slide_0".equals(tag)) {
            return new MiFragmentSimpleSlideBindingLandImpl(component, view);
          }
          if ("layout/mi_fragment_simple_slide_0".equals(tag)) {
            return new MiFragmentSimpleSlideBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for mi_fragment_simple_slide is invalid. Received: " + tag);
        }
        case  LAYOUT_MIFRAGMENTSIMPLESLIDESCROLLABLE: {
          if ("layout-land/mi_fragment_simple_slide_scrollable_0".equals(tag)) {
            return new MiFragmentSimpleSlideScrollableBindingLandImpl(component, view);
          }
          if ("layout/mi_fragment_simple_slide_scrollable_0".equals(tag)) {
            return new MiFragmentSimpleSlideScrollableBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for mi_fragment_simple_slide_scrollable is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new com.android.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(2);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(5);

    static {
      sKeys.put("layout/mi_activity_intro_0", com.example.guiay.adegahouse.R.layout.mi_activity_intro);
      sKeys.put("layout-land/mi_fragment_simple_slide_0", com.example.guiay.adegahouse.R.layout.mi_fragment_simple_slide);
      sKeys.put("layout/mi_fragment_simple_slide_0", com.example.guiay.adegahouse.R.layout.mi_fragment_simple_slide);
      sKeys.put("layout-land/mi_fragment_simple_slide_scrollable_0", com.example.guiay.adegahouse.R.layout.mi_fragment_simple_slide_scrollable);
      sKeys.put("layout/mi_fragment_simple_slide_scrollable_0", com.example.guiay.adegahouse.R.layout.mi_fragment_simple_slide_scrollable);
    }
  }
}
