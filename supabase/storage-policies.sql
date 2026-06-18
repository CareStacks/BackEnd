-- Supabase Storage setup for private medical documents.
-- Run this in the Supabase SQL editor or with the Supabase CLI using a temporary
-- SUPABASE_ACCESS_TOKEN from the shell. Do not store tokens in this repository.

insert into storage.buckets (id, name, public, file_size_limit, allowed_mime_types)
values (
  'documents',
  'documents',
  false,
  10485760,
  array['application/pdf', 'image/jpeg', 'image/png']
)
on conflict (id) do update set
  public = excluded.public,
  file_size_limit = excluded.file_size_limit,
  allowed_mime_types = excluded.allowed_mime_types;

drop policy if exists "documents_select_own_folder" on storage.objects;
drop policy if exists "documents_insert_own_folder" on storage.objects;
drop policy if exists "documents_update_own_folder" on storage.objects;
drop policy if exists "documents_delete_own_folder" on storage.objects;

-- These policies intentionally do not grant public or anon access.
-- They are useful if the mobile app later authenticates directly with Supabase Auth
-- and stores files under: patients/<auth.uid()>/<yyyy>/<mm>/<file>.
-- The current backend upload path uses the service role key server-side only.

create policy "documents_select_own_folder"
on storage.objects
for select
to authenticated
using (
  bucket_id = 'documents'
  and (storage.foldername(name))[1] = 'patients'
  and (storage.foldername(name))[2] = auth.uid()::text
);

create policy "documents_insert_own_folder"
on storage.objects
for insert
to authenticated
with check (
  bucket_id = 'documents'
  and (storage.foldername(name))[1] = 'patients'
  and (storage.foldername(name))[2] = auth.uid()::text
);

create policy "documents_update_own_folder"
on storage.objects
for update
to authenticated
using (
  bucket_id = 'documents'
  and (storage.foldername(name))[1] = 'patients'
  and (storage.foldername(name))[2] = auth.uid()::text
)
with check (
  bucket_id = 'documents'
  and (storage.foldername(name))[1] = 'patients'
  and (storage.foldername(name))[2] = auth.uid()::text
);

create policy "documents_delete_own_folder"
on storage.objects
for delete
to authenticated
using (
  bucket_id = 'documents'
  and (storage.foldername(name))[1] = 'patients'
  and (storage.foldername(name))[2] = auth.uid()::text
);
