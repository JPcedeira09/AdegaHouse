package android.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.example.guiay.adegahouse.DataBinderMapperImpl());
    addMapper(new V1CompatDataBinderMapperImpl());
  }
}
